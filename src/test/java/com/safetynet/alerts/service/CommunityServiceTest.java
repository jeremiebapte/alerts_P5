package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class CommunityServiceTest {

    private static CommunityService communityService;



    @BeforeEach
    void setUp() {
        PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
        communityService = new CommunityService(personRepositoryMock);

    }

    @Test
    public void getAllMail(){

        List<String> actual = communityService.getAllMail("culver");
        assertEquals(1,actual.size());

    }


}