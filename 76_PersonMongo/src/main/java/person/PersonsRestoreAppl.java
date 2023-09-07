package person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import person.dto.Person;
import person.dto.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PersonsRestoreAppl {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(PersonsRestoreAppl.class, args);
		PersonRepository repo = cac.getBean(PersonRepository.class);

		List<Person> list;
//		list = repo.findAll();
//		Person person = repo.findById(594305).orElse(null);
//		list = repo.findByAddressCity("Rehovot");
//		list = repo.findByAddressCityAndBirthDateBetween("Rehovot", LocalDate.ofYearDay(2000, 1), LocalDate.now());
		list = repo.findByAddressCityIn(new String[]{"Haifa", "Rehovot"});

		list.forEach(System.out::println);
	}
}
