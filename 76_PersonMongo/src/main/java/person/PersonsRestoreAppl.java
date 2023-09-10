package person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import person.dto.Child;
import person.dto.Person;
import person.repository.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class PersonsRestoreAppl {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(PersonsRestoreAppl.class, args);
        PersonRepository repo = cac.getBean(PersonRepository.class);
        List<Person> list = null;

//		READ
//		list = repo.findAll();
//		Person person = repo.findById(594305).orElse(null);
//		list = repo.findByAddressCity("Rehovot");
//		List<Person> list = repo.findByAddressCityIgnoreCaseAndBirthDateBetween("Rehovot", LocalDate.ofYearDay(2000, 1), LocalDate.now());
//		list = repo.findByAddressCityIn(new String[]{"Haifa", "Rehovot"});
//		list = repo.findByNameLikeOrderByIdDesc("1");
//		list = repo.findByNameLikeOrIdGreaterThan("10", 500000);

//		list = repo.findBySalaryBetween(20000, 40000);
//		list = repo.getByType("Child");
//		list.forEach(System.out::println);

        System.out.println("Person: " + repo.countPersonByType("person"));
        System.out.println("Employee: " + repo.countPersonByType("Employee"));
        System.out.println("Child " + repo.countPersonByType("Child"));

        Map<String, Long> map = repo.findAllBy().filter(p -> p instanceof Child)
                .collect(Collectors.groupingBy(p -> ((Child) p).garten, Collectors.counting()));

        System.out.println(map);

//		DELETE
//		System.out.println(repo.existsById(594305));
//		repo.deleteById(594305);
//		System.out.println(repo.existsById(594305));

//		list = repo.deleteByIdGreaterThan(800000);
//		list = repo.deleteBySalary(80000);

//		list.forEach(System.out::println);
//		Person person = null;
//
//		System.out.println(person);

//		UPDATE
//		repo.incrementSalary("Employee", 10000);
//		System.out.println(repo.findById(235056));

//      System.out.println("Average salary: " + repo.getAvgSalary());

//      list = repo.getPersonByNameSortingName("2", 5);
//        list.forEach(System.out::println);
        List<String> list1 = repo.getNamesByNameSortingName("5", 5);
        System.out.println(list1);


    }
}
