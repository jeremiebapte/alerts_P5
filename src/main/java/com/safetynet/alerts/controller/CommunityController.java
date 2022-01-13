package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.CommunityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityController {
    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/communityEmail")
    public List<String> personMail(@RequestParam String city){
            return  communityService.getAllMail(city);
    }

}
