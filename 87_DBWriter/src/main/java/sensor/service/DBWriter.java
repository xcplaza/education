package sensor.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import sensor.dto.Sensor;
import sensor.repo.SensorDoc;
import sensor.repo.SensorRepository;

@Service
public class DBWriter
{
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    SensorRepository repository;

    @Bean
    public Consumer<String> receiveSensorData()
    {
        return data ->
        {
            Sensor sensor = null;
            try
            {
                sensor = mapper.readValue(data,  Sensor.class);
            } catch (Exception e)
            {
                System.out.println(e);
            }
            SensorDoc doc = new SensorDoc(sensor.id, sensor.value, sensor.timestamp);
            repository.save(doc);
        };
    }

}
