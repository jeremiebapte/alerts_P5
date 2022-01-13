package com.safetynet.alerts.service;


import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IPersonRepository;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

private final IPersonRepository personRepository;


    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public Person getPerson(String firstName, String lastName){
        Person person = this.personRepository.get(firstName,lastName);
        if(person == null){
            throw new NullPointerException("La personne n'existe pas");
        }
        return person;
    }

    public Set<Person> getByLastName(String lastName){
    return this.personRepository.getByLastName(lastName);

    }


    public Set<Person> getByAdress(String adress){
        Set<Person> allPerson = getAllPersons();
        return allPerson.stream().filter(person ->
                person.getAddress().toLowerCase().equals(adress.toLowerCase()))
                .collect(Collectors.toSet());
    }

    public Set<Person> getAllPersons() {
        return personRepository.getAll();
    }

    public void deletePerson(String firstName, String lastName){
        personRepository.delete(firstName, lastName);

    }

    public Person savePerson(Person newPerson){
         Person person = personRepository.save(newPerson);
         if(person == null){
             throw new IllegalArgumentException("Cette personne existe deja");
         }
         return person;


    }

    public Person updatePerson(String firstName, String lastName, Person person){
        Person person1 = personRepository.update(firstName, lastName, person);
        if (person1 == null){
            throw new NullPointerException("La personne n'existe pas");
        }
        return person1;
    }

}
