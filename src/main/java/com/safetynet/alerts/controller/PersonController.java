package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class PersonController {
private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody @Valid Person newPerson){
        System.out.println("MESSAGE***********");
        return personService.savePerson(newPerson);
    }

    @GetMapping("/persons/{firstName}/{lastName}")
    public Person readPerson(@PathVariable String firstName, @PathVariable String lastName){
        return personService.getPerson(firstName, lastName);
    }

    @GetMapping("/persons")
    public Set<Person> readAllPersons(){
    return personService.getAllPersons();
    }

    @PutMapping("/persons/{firstName}/{lastName}")
    public Person updatePerson(@PathVariable String firstName, @PathVariable String lastName,
                               @RequestBody Person person){

        return personService.updatePerson(firstName, lastName, person);

    }

    @DeleteMapping("/persons/{firstName}/{lastName}")
    public String deletePerson(@PathVariable String firstName, @PathVariable String lastName){
        personService.deletePerson(firstName, lastName);
        return "La personne a été supprimée";

    }
}
