package com.safetynet.alerts.service;


import com.safetynet.alerts.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    private static PersonService personService;

    @Mock
    private static Set<Person> personSet;
    private static Person newPerson;


    @BeforeEach
    void setUp(){
        PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
        personService = new PersonService(personRepositoryMock);
        personSet = new HashSet<>();
        newPerson = new Person();

    }


    @Test
    public void getPerson(){
        Person personGot = personService.getPerson("Eric","Cadigan");
        assertEquals("Eric",personGot.getFirstName());
        assertEquals("Cadigan",personGot.getLastName());

    }

    @Test
    public void getByLastName(){
       Set<Person> personsGot = personService.getByLastName("Stelzer");
       assertEquals(2,personsGot.size());


    }

    @Test
    public void getByAdress(){
         Set<Person> personGot = personService.getByAdress("947 E. Rose Dr");
        assertEquals(2, personGot.size());

    }

    @Test
    public void getAll(){
        personSet = personService.getAllPersons();
        assertEquals(4,personSet.size());

    }

    @Test
    public void deletePerson(){
        personSet = personService.getAllPersons();
        assertEquals(4,personSet.size());

        personService.deletePerson("Eric","Cadigan");
        personSet = personService.getAllPersons();
        assertEquals(3,personSet.size());
    }

    @Test
    public void savePerson() {
        personSet = personService.getAllPersons();
        assertEquals(4, personSet.size());

        personService.savePerson(newPerson);
        personSet = personService.getAllPersons();
        assertEquals(5, personSet.size());
    }

        @Test
        public void updatePerson(){
            Person person = personService.getPerson("Eric","Cadigan");

            personService.updatePerson("Eric","Cadigan",person);
            person.setEmail("ricoC@mail.com");
            assertEquals("ricoC@mail.com",person.getEmail());

        }






}
