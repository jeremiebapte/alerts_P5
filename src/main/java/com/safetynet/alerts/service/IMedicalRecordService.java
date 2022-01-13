package com.safetynet.alerts.service;

import com.safetynet.alerts.model.MedicalRecord;

import java.util.Set;

public interface IMedicalRecordService {

    MedicalRecord getMedicalRecord(String firstName, String lastName);
    Set<MedicalRecord> getAllMedicalRecords();
    void deleteMedicalRecord(String firstName, String lastName);
    MedicalRecord saveMedicalRecord(MedicalRecord newMedicalRecord);
    MedicalRecord updateMedicalRecord(String firstName, String lastName, MedicalRecord update);

}
