package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IPersonRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class PersonServiceMock implements IPersonService {

    private final IPersonRepository personRepository;


    public PersonServiceMock(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Set<Person> getAllPersons() {
        return personRepository.getAll();
    }

    @Override
    public Person getPerson(String firstName, String lastName) {
        Person person = this.personRepository.get(firstName,lastName);
        if(person == null){
            throw new NullPointerException("La personne n'existe pas");
        }
        return person;
    }

    @Override
    public Set<Person> getByLastName(String lastName) {
        return this.personRepository.getByLastName(lastName);
    }

    @Override
    public Set<Person> getByAdress(String adress) {
        Set<Person> allPerson = getAllPersons();
        return allPerson.stream().filter(person ->
                person.getAddress().toLowerCase().equals(adress.toLowerCase()))
                .collect(Collectors.toSet());
    }

    @Override
    public void deletePerson(String firstName, String lastName) {
        personRepository.delete(firstName, lastName);
    }

    @Override
    public Person savePerson(Person newPerson) {
        Person person = personRepository.save(newPerson);
        if(person == null){
            throw new IllegalArgumentException("Cette personne existe deja");
        }
        return person;
    }

    @Override
    public Person updatePerson(String firstName, String lastName, Person person) {
        Person person1 = personRepository.update(firstName, lastName, person);
        if (person1 == null){
            throw new NullPointerException("La personne n'existe pas");
        }
        return person1;

    }
}
