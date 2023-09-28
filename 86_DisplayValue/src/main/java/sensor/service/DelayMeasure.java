package sensor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sensor.dto.Sensor;
import java.util.function.Consumer;

@Service
public class DelayMeasure {
    ObjectMapper mapper = new ObjectMapper(); // function for create JSON

    @Bean
    public Consumer<String> receiveSensorData() {
        return sensorData -> {
            Sensor sensor = null;
            try {
                sensor = mapper.readValue(sensorData, Sensor.class);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.printf("Serial number: %d, Patient id: %d, Delay: %d\n", sensor.serNumber, sensor.id, System.currentTimeMillis() - sensor.timestamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
