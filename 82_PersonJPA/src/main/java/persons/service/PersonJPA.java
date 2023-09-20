package persons.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persons.entities.Address;
import persons.entities.Person;
import persons.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonJPA implements IPerson {
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
}
