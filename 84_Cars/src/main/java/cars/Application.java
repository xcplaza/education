package cars;

import cars.domain.entities.Car;
import cars.domain.entities.Model;
import cars.domain.entities.Owner;
import cars.domain.repo.CarsRepository;
import cars.domain.repo.ModelsRepository;
import cars.domain.repo.OwnersRepository;
import cars.service.CarsJPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ConfigurableApplicationContext cac = SpringApplication.run(Application.class, args);
        CarsRepository cr = cac.getBean(CarsRepository.class);
        ModelsRepository mr = cac.getBean(ModelsRepository.class);
        OwnersRepository or = cac.getBean(OwnersRepository.class);
        CarsJPA service = cac.getBean(CarsJPA.class);

        Owner owner = new Owner(1, "name", 2000, null);
        Model model = new Model("model", 10, "company");
        or.save(owner);
        mr.save(model);
        cr.save(new Car(1, "color", LocalDate.now(), model, owner));

        System.out.println(service.getCar(1));
        System.out.println(service.getCarOwner(1));
    }
}
