package com.safetynet.alerts.service;

import com.safetynet.alerts.dto.FireDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonFireServiceTest {


    private static PersonFireService personFireService;


    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
    private MedicalRecordRepositoryMock medicalRecordRepositoryMock = new MedicalRecordRepositoryMock();
    private FireStationRepositoryMock fireStationRepositoryMock = new FireStationRepositoryMock();


    @BeforeEach
    void setup(){
        PersonService personService = new PersonService(personRepositoryMock);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepositoryMock);
        FireStationService fireStationService = new FireStationService(fireStationRepositoryMock);
        personFireService = new PersonFireService(personService,fireStationService,medicalRecordService);
    }

    @Test
    void fireAdress(){

        FireDTO fireDTO = personFireService.fireAdress("1509 Culver St");
        assertNotNull(fireDTO);
        assertEquals(3,fireDTO.getStationNumber());
    }
    @Test
    void fireAdressException(){
        assertThrows(IllegalArgumentException.class,()->personFireService.fireAdress("Fake Adress"));
    }



}
