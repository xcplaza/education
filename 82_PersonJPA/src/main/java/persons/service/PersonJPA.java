package persons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persons.entities.Address;
import persons.entities.Person;
import persons.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonJPA implements IPerson{
    @Autowired
    PersonRepository repository;

    @Override
    public boolean addPerson(Person person) {
        return false;
    }

    @Override
    public boolean removePerson(int Id) {
        return false;
    }

    @Override
    public List<Person> getPerson() {
        return null;
    }

    @Override
    public List<Person> getPersonByCity(String city) {
        return null;
    }

    @Override
    public List<Person> getPersonByBirthDates(LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public boolean updateAddress(int id, Address address) {
        return false;
    }
}
