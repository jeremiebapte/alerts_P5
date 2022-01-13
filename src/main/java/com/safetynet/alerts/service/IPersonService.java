package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;

import java.util.Set;

public interface IPersonService {

     Set<Person>getAllPersons();
     Person getPerson(String firstName, String lastName);
     Set<Person> getByLastName(String lastName);
     Set<Person> getByAdress(String adress);
     void deletePerson(String firstName, String lastName);
     Person savePerson(Person newPerson);
     Person updatePerson(String firstName, String lastName, Person person);

}
