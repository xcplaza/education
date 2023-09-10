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
		List<Person> list = null;

		//		list = repo.findAll();
//		Person person = repo.findById(594305).orElse(null);
//		list = repo.findByAddressCity("Rehovot");
//		List<Person> list = repo.findByAddressCityIgnoreCaseAndBirthDateBetween("Rehovot", LocalDate.ofYearDay(2000, 1), LocalDate.now());
//		list = repo.findByAddressCityIn(new String[]{"Haifa", "Rehovot"});
//		list = repo.findByNameLikeOrderByIdDesc("1");
//		list = repo.findByNameLikeOrIdGreaterThan("10", 500000);
		list = repo.findBySalaryBetween(20000, 40000);

		list.forEach(System.out::println);
	}
}
