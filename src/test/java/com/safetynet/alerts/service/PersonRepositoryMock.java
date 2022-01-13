package com.safetynet.alerts.service;


import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IPersonRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonRepositoryMock implements IPersonRepository {
    private Set<Person> people = new HashSet<>();

    public PersonRepositoryMock() {
        init();

    }

    void init(){

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setEmail("jaboyd@email.com");
        person.setCity("Culver");
        person.setZip(97451);
        person.setPhone("841-874-6512");


        Person person2 = new Person();
        person2.setFirstName("Clive");
        person2.setLastName("Ferguson");
        person2.setAddress("748 Townings Dr");
        person2.setEmail("clivfd@ymail.com");
        person2.setCity("Culver");
        person2.setZip(97451);
        person2.setPhone("841-874-6741");

        Person person3 = new Person();
        person3.setFirstName("Kendrik");
        person3.setLastName("Stelzer");
        person3.setAddress("947 E. Rose Dr");
        person3.setEmail("bstel@email.com");
        person3.setCity("Culver");
        person3.setZip(97451);
        person3.setPhone("841-874-7784");

        Person person4 = new Person();
        person4.setFirstName("Shawna");
        person4.setLastName("Stelzer");
        person4.setAddress("947 E. Rose Dr");
        person4.setEmail("ssanw@email.com");
        person4.setCity("Culver");
        person4.setZip(97451);
        person4.setPhone("841-874-7784");

        people = new HashSet<Person>(){{

            add(person);
            add(person2);
            add(person3);
            add(person4);
        }};

    }
    @Override
    public Set<Person> getAllPersons() {
        Person person = new Person();
        person.setCity("culver");
        person.setFirstName("Jérémie");
        person.setLastName("Bapté");
        person.setEmail("jeremie@gmail.com");

        Set<Person> personSet = new HashSet<Person>() {{
        add(person);
        }

        };
        return personSet;


    }

    @Override
    public Set<Person> getAll() {
        return this.people;
    }

    @Override
    public Person get(String firstName, String lastName) {
        Person person = this.people.stream().filter(person1 ->
                person1.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                        && person1.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .findFirst().orElse(null);

        return person;
    }

    @Override
    public Set<Person> getByLastName(String lastName) {
        return this.people.stream().filter(person ->
                person.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(String firstName, String lastName) {
        this.people = this.people.stream().filter(person ->
                !person.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                        && !person.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toSet());
    }

    @Override
    public Person save(Person newPerson) {
        boolean result = this.people.add(newPerson);
        if (!result){
            return null;
        }
        return newPerson;
    }

    @Override
    public Person update(String firstName, String lastName, Person update) {
        Person person = get(firstName, lastName);
        if (person == null){
            return null;
        }
        this.people.remove(person);
        this.people.add(update);
        return update;
    }
}
