package sensor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sensor.dto.Sensor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class AvgProcessor {
    ObjectMapper mapper = new ObjectMapper(); // function for create JSON

    @Autowired
    StreamBridge bridge;

    @Value("${period:10}")
    int period;

    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    Instant timestamp = Instant.now();

    @Bean
    public Consumer<String> receiveSensorData() {
        return data -> {
            Sensor sensor = null;
            try {
                sensor = mapper.readValue(data, Sensor.class);
            } catch (Exception e) {
                System.out.println(e);
            }
            addToMap(sensor.id, sensor.value);
            if (ChronoUnit.SECONDS.between(timestamp, Instant.now()) >= period)
                avgProcessing();
        };
    }

    private void avgProcessing() {
        timestamp = Instant.now();
        map.forEach((k, v) -> bridge.send("avgData-out-0", getPlayload(k, v)));
        map.clear();
    }

    private String getPlayload(final Integer k, final List<Integer> v) {
        Sensor sensor = new Sensor(System.currentTimeMillis(), k, (int) (v.stream().collect(Collectors.averagingInt(x -> x)) + 0.5));
        try {
            return mapper.writeValueAsString(sensor);
        } catch (Exception e) {
            return null;
        }
    }

    private void addToMap(final int id, final int value) {
        List<Integer> list = map.getOrDefault(id, new ArrayList<>());
        list.add(value);
        map.putIfAbsent(id, list);
    }
}
