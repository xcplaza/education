import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalAppl {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("Alex", 25), new Person("John", 28), new Person("Mary", 17));

		Optional<Person> res = findPersonByAge(list, 20);
		if (res.isPresent()) {
			Person person = res.get();
			System.out.println("1: " + person.name);
		}
		res.ifPresent(p -> System.out.println("2: " + p.name));

//		если не находим по условию - выводим default свой
		Person person = res.orElse(new Person("Anonimous", 120));
		System.out.println(person.name);

//		если не находим по условию - выводим из списка
		person = res.orElseGet(() -> list.get(1));
		System.out.println(person.name);

//		если не находим по условию - кидаем exception
		person = res.orElseThrow(() -> new IllegalArgumentException());
		person = res.orElseThrow(IllegalArgumentException::new);
	}

	private static Optional<Person> findPersonByAge(List<Person> list, int age) {
		Person res = null;
		for (Person p : list) {
			if (p.age == age) {
				res = p;
				break;
			}
		}
		return Optional.ofNullable(res);
	}

}
