package sensor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sensor.dto.Sensor;

import java.util.Random;
import java.util.function.Supplier;

@Service
public class SensorGenerator {
    int sNumber = 1;
    ObjectMapper mapper = new ObjectMapper(); // function for create JSON

    @Value("${min_value:30}")
    private int minValue;
    @Value("${n_patients:10}")
    private int nPatients;
    @Value("${max_value:250}")
    private int maxValue;

    @Bean
    public Supplier<String> sendSensorData() {
        return () -> {
            Sensor sensor = getRandomSensor();
            try {
                return mapper.writeValueAsString(sensor); // create JSON and return
            } catch (Exception e) {
                return null;
            }
        };
    }

    private Sensor getRandomSensor() {
        long timestamp = System.currentTimeMillis();
        int id = getRandomNumber(1, nPatients);
        int value = getRandomNumber(minValue, maxValue);
        Sensor sensor = new Sensor(timestamp, id, value);
        sensor.serNumber = sNumber++;
        return sensor;
    }

    private int getRandomNumber(int min, int max) {
        return new Random().ints(1, min, max + 1).findFirst().getAsInt();
    }
}
