package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommunityService {

   private final IPersonRepository personRepository;

    public CommunityService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<String> getAllMail(String city){
        Set<Person> personSet =  personRepository.getAllPersons();
        personSet = personSet.stream().filter(person ->
                person.getCity().toLowerCase().equals(city.toLowerCase()))
                .collect(Collectors.toSet());

        List<String> emails = personSet.stream().map(person -> person.getEmail())
                .collect(Collectors.toList());
            return emails;
    }
}
