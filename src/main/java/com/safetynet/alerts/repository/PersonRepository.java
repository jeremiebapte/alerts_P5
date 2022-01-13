package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.ArrayContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements IPersonRepository{


    private final ArrayContainer data;
    private Set<Person> persons = new HashSet<>();


    public PersonRepository(ArrayContainer data){
        this.data = data;
        this.persons = this.data.getPersons();
        System.out.println(this.persons);
    }

    @Override// Méthode pour CommunityService
    public Set<Person> getAllPersons() {
        return this.persons;
    }

    public Set<Person> getAll(){
        return this.persons;
    }

    public Person get(String firstName, String lastName){
        Person person = this.persons.stream().filter(person1 ->
                person1.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                && person1.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .findFirst().orElse(null);

        return person;

    }

    public Set<Person> getByLastName(String lastName){
        return this.persons.stream().filter(person ->
                person.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toSet());

    }

    public void delete(String firstName, String lastName){
        this.persons = this.persons.stream().filter(person ->
                !person.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                && !person.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toSet());

    }

    public Person save(Person newPerson) {
        boolean result = this.persons.add(newPerson);
        if (!result){
            return null;
        }
        return newPerson;

    }

    public Person update(String firstName, String lastName,Person update){
        Person person = get(firstName, lastName);
        if (person == null){
            return null;
        }
        this.persons.remove(person);
        this.persons.add(update);
        return update;



    }



}
