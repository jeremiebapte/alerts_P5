package com.safetynet.alerts.service;

import com.safetynet.alerts.model.MedicalRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

    private static MedicalRecordService medicalRecordService;

    @Mock
    private static Set<MedicalRecord> medicalRecordSet;
    private static MedicalRecord newMedicalRecord;
    private static Set<String> medications;

    @BeforeEach
        void setUp() {

        MedicalRecordRepositoryMock medicalRecordRepositoryMock = new MedicalRecordRepositoryMock();
        medicalRecordService = new MedicalRecordService(medicalRecordRepositoryMock);
        medicalRecordSet = new HashSet<>();
        newMedicalRecord = new MedicalRecord();
        medications = new HashSet<>();
        medications.add("Fish");

    }



    @Test
    public void getMedicalRecord(){
        MedicalRecord medicalRecordGot = medicalRecordService.getMedicalRecord("Tony","Cooper");
        assertEquals("Tony",medicalRecordGot.getFirstName());
        assertEquals("Cooper",medicalRecordGot.getLastName());

    }

    @Test
    public void getAllMedicalRecord(){
        medicalRecordSet = medicalRecordService.getAllMedicalRecords();
        assertEquals(3,medicalRecordSet.size());

    }

    @Test
    void deleteMedicalRecord() {
        medicalRecordSet = medicalRecordService.getAllMedicalRecords();
        assertEquals(3,medicalRecordSet.size());

        medicalRecordService.deleteMedicalRecord("Tony", "Cooper");
        medicalRecordSet = medicalRecordService.getAllMedicalRecords();
        assertEquals(2,medicalRecordSet.size());
    }

    @Test
    void saveMedicalRecord() {
        medicalRecordSet = medicalRecordService.getAllMedicalRecords();
        assertEquals(3,medicalRecordSet.size());

        medicalRecordService.saveMedicalRecord(newMedicalRecord);

        medicalRecordSet = medicalRecordService.getAllMedicalRecords();
        assertEquals(4,medicalRecordSet.size());

    }

    @Test
    void updateMedicalRecord() {

        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord("Tony", "Cooper");
        assertEquals("Tony",medicalRecord.getFirstName());
        assertEquals("Cooper",medicalRecord.getLastName());
        medicalRecord.setMedications(medications);

      MedicalRecord recordUpdated = medicalRecordService.updateMedicalRecord("Tony",
              "Cooper",medicalRecord);
      assertEquals("Tony",recordUpdated.getFirstName());
      assertEquals("Cooper",recordUpdated.getLastName());
      assertEquals(medications,recordUpdated.getMedications());




    }
}
