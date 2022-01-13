package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.MedicalRecord;

import java.util.Set;

public interface IMedicalRecordRepository {



    Set<MedicalRecord> getAll();
    MedicalRecord get(String firstName, String lastName);
    void delete(String firstName, String lastName);
    MedicalRecord save(MedicalRecord newMedicalRecord);
    MedicalRecord update(String firstName, String lastName, MedicalRecord update);

}
