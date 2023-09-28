package sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DelayApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DelayApplication.class, args);
    }

}
