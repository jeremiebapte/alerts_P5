package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.Person;

import java.util.Set;

public interface IPersonRepository {


    Set<Person>getAllPersons();
    Set<Person> getAll();
    Person get(String firstName, String lastName);
    Set<Person> getByLastName(String lastName);
    void delete(String firstName, String lastName);
    Person save(Person newPerson);
    Person update(String firstName, String lastName,Person update);
}
