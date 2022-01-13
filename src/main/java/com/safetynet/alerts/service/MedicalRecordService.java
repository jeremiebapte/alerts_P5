package com.safetynet.alerts.service;


import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.IMedicalRecordRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MedicalRecordService implements IMedicalRecordService {
    private final IMedicalRecordRepository medicalRecordRepository;


    public MedicalRecordService(IMedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicalRecord getMedicalRecord(String firstName, String lastName){
        MedicalRecord medicalRecord = this.medicalRecordRepository.get(firstName, lastName);
        if (medicalRecord == null){
            throw new NullPointerException("Cet enregistrement médical n'existe pas");
        }
        return medicalRecord;
    }

    public Set<MedicalRecord> getAllMedicalRecords(){
        return this.medicalRecordRepository.getAll();
    }

    public void deleteMedicalRecord(String firstName, String lastName){
        this.medicalRecordRepository.delete(firstName, lastName);
    }

    public MedicalRecord saveMedicalRecord(MedicalRecord newMedicalRecord){
        MedicalRecord medicalRecord = this.medicalRecordRepository.save(newMedicalRecord);
        if (medicalRecord == null){
            throw new NullPointerException("Cet enregistrement médical existe déja");
        }
        return newMedicalRecord;
    }

    public MedicalRecord updateMedicalRecord(String firstName, String lastName, MedicalRecord update){
        MedicalRecord medicalRecord = this.medicalRecordRepository.update(firstName, lastName, update);
        if (medicalRecord == null){
            throw new NullPointerException("Cet enregistrement médical n'existe pas");
        }
        return medicalRecord;
    }

}
