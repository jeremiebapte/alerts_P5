package com.safetynet.alerts.controller;


import com.safetynet.alerts.dto.ChildPerHouse;
import com.safetynet.alerts.service.ListOfChildrenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListOfChildrenController {

    private final ListOfChildrenService listOfChildrenService;


    public ListOfChildrenController(ListOfChildrenService listOfChildrenService) {
        this.listOfChildrenService = listOfChildrenService;
    }

    @GetMapping("/childAlert")
    public ResponseEntity childrenAlert(@RequestParam String address){
        ChildPerHouse childPerHouse = listOfChildrenService.childAlert(address);
        if (childPerHouse.getChildren().size() == 0){
            return ResponseEntity.ok("");
        }
            return ResponseEntity.ok(childPerHouse);
    }

}
