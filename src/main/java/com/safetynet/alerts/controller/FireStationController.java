package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.service.FireStationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class FireStationController {
private final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @PostMapping("/firestations")
    public FireStation createFireStation(@RequestBody FireStation newFireStation){
        return fireStationService.saveStation(newFireStation);
    }
    @GetMapping("/firestations")
        public Set<FireStation> readAllStations(){
        return fireStationService.getAllStations();
    }


    @GetMapping("/firestations/{station}")
    public FireStation readFireStation( @PathVariable int station){
       return fireStationService.getStation( station);
    }


    @PutMapping("/firestations/{station}")
    public FireStation updateFireStation( @PathVariable int station,
                                         @RequestBody FireStation fireStation){
        return fireStationService.updateFireStation(station, fireStation);
    }
    @DeleteMapping("/firestations/{station}")
    public String deleteFireStation(@PathVariable int station ){
        fireStationService.deleteStation(station);
        return "La station a été supprimée";

    }
}
