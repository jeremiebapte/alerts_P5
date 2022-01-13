package com.safetynet.alerts.controller;


import com.safetynet.alerts.dto.PersonPerAge;
import com.safetynet.alerts.service.PersonCoverByFireStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonCoverByFireStationController {

   private final PersonCoverByFireStationService personCoverByFireStationService;

   public PersonCoverByFireStationController(PersonCoverByFireStationService personCoverByFireStationService) {
      this.personCoverByFireStationService = personCoverByFireStationService;
   }

   @GetMapping("/firestation")
   public PersonPerAge personByFireStation(@RequestParam int stationNumber){
   return personCoverByFireStationService.personCoverFireStation(stationNumber);

}
}
