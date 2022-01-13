package com.safetynet.alerts.controller;


import com.safetynet.alerts.dto.FloodStation;
import com.safetynet.alerts.dto.PersonFlood;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.service.FloodStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class FloodStationController {

    private final FloodStationService floodStationService;

    public FloodStationController(FloodStationService floodStationService) {
        this.floodStationService = floodStationService;
    }

    @GetMapping("/flood/stations")
    public Map<String, List<PersonFlood>> stationFlood(@RequestParam List<Integer> stations){
        return floodStationService.floodStation(stations);

    }
}
