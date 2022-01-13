package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.MedicalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MedicalRecordController {
private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }


    @GetMapping("/medicalrecords/{firstName}/{lastName}")
    public MedicalRecord readMedicalRecords(@PathVariable String firstName, @PathVariable String lastName){
        return medicalRecordService.getMedicalRecord(firstName, lastName);
    }

    @GetMapping("/medicalrecords")
    public Set<MedicalRecord> readAllMedicalRecords(){
    return medicalRecordService.getAllMedicalRecords();
    }

    @PutMapping("/medicalrecords/{firstName}/{lastName}")
    public MedicalRecord updateMedicalRecord(@PathVariable String firstName, @PathVariable String lastName,
                                             @RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.updateMedicalRecord(firstName, lastName, medicalRecord);
    }

    @PostMapping("/medicalrecords")
    public MedicalRecord createMedicalRecords(@RequestBody MedicalRecord newMedicalRecord){
        return medicalRecordService.saveMedicalRecord(newMedicalRecord);
    }

    @DeleteMapping("/medicalrecords/{firstName}/{lastName}")
    public String deleteMedicalRecords(@PathVariable String firstName, @PathVariable String lastName){
        medicalRecordService.deleteMedicalRecord(firstName, lastName);
        return "L'enregistrement médical a été supprimé";
    }
}
