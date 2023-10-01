package sensor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sensor.dto.Sensor;

import java.util.function.Consumer;

@Service
public class AvgProcessor {
    ObjectMapper mapper = new ObjectMapper(); // function for create JSON

    @Autowired
    StreamBridge bridge;

    @Value("${min_normal_value:100}")
    int minNormalValue;

    @Value("${max_normal_value:220}")
    int maxNormalValue;

    @Bean
    public Consumer<Sensor> receiveSensorData() {
        return data -> {
            if (data.value < minNormalValue)
                bridge.send("lowData-out-0", data);
            if (data.value > maxNormalValue)
                bridge.send("highData-out-0", data);
            bridge.send("normalData-out-0", data);
        };
    }
}
