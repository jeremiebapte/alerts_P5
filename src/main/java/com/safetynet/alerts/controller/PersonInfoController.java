package com.safetynet.alerts.controller;


import com.safetynet.alerts.dto.PersonInfo;
import com.safetynet.alerts.dto.PersonInfoList;
import com.safetynet.alerts.service.PersonInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {
    private final PersonInfoService personInfoService;


    public PersonInfoController(PersonInfoService personInfoService) {
        this.personInfoService = personInfoService;
    }

@GetMapping("/personInfo")
    public List <PersonInfo> infoPerson (@RequestParam String firstName, @RequestParam String lastName){
       return personInfoService.getAllInfo(firstName, lastName);
}


}

