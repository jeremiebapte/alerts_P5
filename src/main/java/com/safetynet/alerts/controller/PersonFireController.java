package com.safetynet.alerts.controller;


import com.safetynet.alerts.dto.FireDTO;
import com.safetynet.alerts.dto.PersonFire;
import com.safetynet.alerts.service.PersonFireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonFireController {

    private final PersonFireService personFireService;

    public PersonFireController(PersonFireService personFireService) {
        this.personFireService = personFireService;
    }

    @GetMapping("/fire")
    public FireDTO fireAdress(@RequestParam String address){
       return personFireService.fireAdress(address);

    }
}
