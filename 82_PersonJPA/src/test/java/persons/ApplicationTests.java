package persons;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import persons.entities.Address;
import persons.entities.Person;
import persons.service.IPerson;

@SpringBootTest
class ApplicationTests {

    @Autowired
    IPerson service;

    Person person = new Person(1, "Masha", new Address("Haifa", "Hanita", 10), LocalDate.of(2000, 10, 10));

    @BeforeEach
    public void setUp() {
        service.addPerson(person);
    }

    @AfterEach
    public void tearDown() {
        service.removePerson(1);
    }

    @Test
    void testAddPerson()
    {
        assertNotNull(service.getPersonById(1));
        assertFalse(service.addPerson(person));
    }

    @Test
    void testRemovePerson()
    {
        assertTrue(service.removePerson(1));
        assertFalse(service.removePerson(1));
        assertNull(service.getPersonById(1));
        assertTrue(service.addPerson(person));
    }

    @Test
    void testGetPersons()
    {
        List<Person> list = service.getPerson();
        assertEquals(1, list.size());
        assertTrue(list.contains(person));
        assertEquals(person, list.get(0));
    }

    @Test
    void testGetPersonsByCity()
    {
        List<Person> listHaifa = service.getPersonByCity("Haifa");
        assertEquals(1, listHaifa.size());
        assertTrue(listHaifa.contains(person));
        assertEquals(person, listHaifa.get(0));

        List<Person> listLod = service.getPersonByCity("Lod");
        assertTrue(listLod.isEmpty());
    }

    @Test
    void testGetPersonsByBirthdates()
    {
        List<Person> list = service.getPersonByBirthDates(LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1));
        assertEquals(1, list.size());
        assertTrue(list.contains(person));
        assertEquals(person, list.get(0));

        List<Person> listEmpty = service.getPersonByBirthDates(LocalDate.of(1980, 1, 1), LocalDate.of(1990, 1, 1));
        assertTrue(listEmpty.isEmpty());
    }

    @Test
    void testGetPersonById()
    {
        assertEquals(person, service.getPersonById(1));
        assertNull(service.getPersonById(2));
    }

    @Test
    void testUpdateAddress()
    {
        assertFalse(service.updateAddress(2, new Address("Lod", "Blablabla", 10)));
        assertTrue(service.updateAddress(1, new Address("Lod", "Blablabla", 10)));
        List<Person> listLod = service.getPersonByCity("Lod");
        assertEquals(1, listLod.size());

        person.setAddress(new Address("Lod", "Blablabla", 10));
        assertTrue(listLod.contains(person));
        assertEquals(person, listLod.get(0));
    }

}
