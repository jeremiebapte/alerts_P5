package com.safetynet.alerts.service;


import com.safetynet.alerts.dto.PersonInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PersonInfoServiceTest {


    private static PersonInfoService personInfoService;


    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
    private MedicalRecordRepositoryMock medicalRecordRepositoryMock = new MedicalRecordRepositoryMock();



    @BeforeEach
    void setup(){


        PersonServiceMock personServiceMock = new PersonServiceMock(personRepositoryMock);
        MedicalRecordServiceMock medicalRecordServiceMock = new MedicalRecordServiceMock(medicalRecordRepositoryMock);
        personInfoService = new PersonInfoService(personServiceMock,medicalRecordServiceMock);

    }


    @Test
    void getAllInfo(){

        List<PersonInfo> personInfos = personInfoService.getAllInfo("John","Boyd");
        assertFalse(personInfos.isEmpty());
        assertEquals(1,personInfos.size());
        assertEquals("John", personInfos.get(0).getFirstName());
        assertEquals("Boyd", personInfos.get(0).getLastName());

        List<PersonInfo> personInfoList = personInfoService.getAllInfo("Kendrik","Stelzer");
        assertFalse(personInfoList.isEmpty());
        assertEquals(2,personInfoList.size());



    }
}
