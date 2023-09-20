package persons.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import persons.entities.Address;
import persons.entities.Child;
import persons.entities.Employee;
import persons.entities.Person;
import persons.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonJPA implements IPerson, CommandLineRunner {
    @Autowired
    PersonRepository repository;

    @Override
    @Transactional
    public boolean addPerson(Person person) {
        if (repository.existsById(person.getId()))
            return false;
        repository.save(person);
        return true;
    }

    @Override
    @Transactional
    public boolean removePerson(int Id) {
        if (!repository.existsById(Id))
            return false;
        repository.deleteById(Id);
        return true;
    }

    @Override
    public List<Person> getPerson() {
        return repository.findAll();
    }

    @Override
    public List<Person> getPersonByCity(String city) {
        return repository.findByAddressCity(city);
    }

    @Override
    public List<Person> getPersonByBirthDates(LocalDate from, LocalDate to) {
        return repository.findByBirthDateBetween(from, to);
    }

    @Override
    public Person getPersonById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean updateAddress(int id, Address address) {
        Person person = getPersonById(id);
        if (person == null)
            return false;
        person.setAddress(address);
        return true;
    }

    @Override
    @Transactional
    public Person updatePersonName(final int id, final String name) {
        Person person = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person is not exists!"));
        person.setName(name);
        return person;
    }

    @Override
    public List<Person> findPersonsByName(final String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Person> findPersonsBetweenAges(final int minAge, final int maxAge) {
        LocalDate from = LocalDate.now().minusYears(maxAge);
        LocalDate to = LocalDate.now().minusYears(minAge);
        return repository.findByBirthDateBetween(from, to);
    }

    @Override
    public void run(final String... args) throws Exception {
//        if(!repository.existsById(1))
        repository.save(new Person(1, "Masha", new Address("Haifa", "Hanita", 10), LocalDate.of(2000, 10, 10)));
        repository.save(new Child(2, "Sasha", new Address("Haifa", "Hanita", 10), LocalDate.of(2000, 10, 10), "garten"));
        repository.save(new Employee(3, "Pasha", new Address("Haifa", "Hanita", 10), LocalDate.of(2000, 10, 10), "IBM"));
    }
}
