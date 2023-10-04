package sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedHashMap;

@SpringBootApplication
public class SensorApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext cac = SpringApplication.run(SensorApplication.class, args);
//        SpringApplication.run(SensorApplication.class, args);
        Thread.sleep(100000);
        cac.close();
    }
}