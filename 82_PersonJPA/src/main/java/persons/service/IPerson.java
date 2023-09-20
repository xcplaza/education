package persons.service;

import persons.entities.Address;
import persons.entities.Person;

import java.time.LocalDate;
import java.util.List;

public interface IPerson {
    boolean addPerson(Person person);
    boolean removePerson(int Id);
    List<Person> getPerson();
    List<Person> getPersonByCity(String city);
    List<Person> getPersonByBirthDates(LocalDate from, LocalDate to);
    Person getPersonById(int id);
    boolean updateAddress(int id, Address address);

    Person updatePersonName(int id, String name);
	List<Person> findPersonsByName(String name);
    List<Person> findPersonsBetweenAges(int minAge, int maxAge);
}
