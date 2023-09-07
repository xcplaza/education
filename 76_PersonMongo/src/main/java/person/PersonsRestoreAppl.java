package person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import person.dto.Person;
import person.dto.PersonRepository;

import java.util.List;

@SpringBootApplication
public class PersonsRestoreAppl {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(PersonsRestoreAppl.class, args);
		PersonRepository repo = cac.getBean(PersonRepository.class);

//		List<Person> list = repo.findAll();
//		list.forEach(System.out::println);

		Person person = repo.findById(594305).orElse(null);
		System.out.println(person);
	}
}
