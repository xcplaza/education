package persons;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class PersonCreateAppl {
	private static final int N_PERSONS = 100;
	private static final int EMP_PROBOBILITY = 50;
	private static final int MAX_CHILD_YEAR = 2023;
	private static final int MIN_CHILD_YEAR = 2005;
	private static final int MAX_EMP_YEAR = 2007;
	private static final int MIN_EMP_YEAR = 1950;
	private static final String[] CITIES = new String[] { "Haifa", "Tel-Aviv", " Bat yam", "Rehovot" };
	private static final int N_GARTENS = 5;
	private static final String[] COMPANIES = new String[] { "IBM", "Microsoft", "Intel", "Apple" };
	private static final int MIN_SALARY = 5000;
	private static final int MAX_SALARY = 100000;
	private static final String[] TITLES = new String[] { "programmer", "manager", "cleaner", "qa" };

	public static void main(String[] args) {
		new Person(1, "name", LocalDate.now(), new Address("city", "street", 0, 0));
		new Child(2, "nameC", LocalDate.now(), new Address("city", "street", 0, 0), "garten");
		new Employee(3, "nameE", LocalDate.now(), new Address("city", "street", 0, 0), "company", 10000,
				"title");
		List<Person> list = getRandomPersons();
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("persons.data"))) {
			out.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Person> getRandomPersons() {
		return Stream.generate(PersonCreateAppl::getRandomPers).limit(N_PERSONS).toList();
	}

	private static Person getRandomPers() {
		Person person = getRandomCommonPerson();
		return getRandomNumber(1, 100) < EMP_PROBOBILITY ? getRandomEmpoloyee(person) : getRandomChild(person);
	}

	private static Person getRandomChild(Person person) {
		LocalDate date = getRandomDate(MIN_CHILD_YEAR, MAX_CHILD_YEAR);
		String garten = "garten" + getRandomNumber(1, N_GARTENS);
		return new Child(person.id, person.name, date, person.address, garten);
	}

	private static Person getRandomEmpoloyee(Person person) {
		LocalDate date = getRandomDate(MIN_EMP_YEAR, MAX_EMP_YEAR);
		String company = COMPANIES[getRandomNumber(0, COMPANIES.length - 1)];
		int salary = getRandomNumber(MIN_SALARY, MAX_SALARY);
		String title = TITLES[getRandomNumber(0, TITLES.length - 1)];
		return new Employee(person.id, person.name, date, person.address, company, salary, title);
	}

	private static LocalDate getRandomDate(int minYear, int maxYear) {
		int year = getRandomNumber(minYear, maxYear);
		int month = getRandomNumber(1, 12);
		getRandomNumber(1, 28);
		return LocalDate.of(year, month, month);
	}

	private static Person getRandomCommonPerson() {
		int id = getRandomNumber(1, 1000000);
		String name = "name" + getRandomNumber(1, 100);
		Address address = getRandomAddress();
		return new Person(id, name, null, address);
	}

	private static Address getRandomAddress() {
		String city = CITIES[getRandomNumber(0, CITIES.length - 1)];
		String street = "street" + getRandomNumber(1, 100);
		int building = getRandomNumber(1, 500);
		int flat = getRandomNumber(1, 50);
		return new Address(city, street, building, flat);
	}

	private static int getRandomNumber(int min, int max) {
		return new Random().ints(1, min, max + 1).findFirst().getAsInt();
	}

}
