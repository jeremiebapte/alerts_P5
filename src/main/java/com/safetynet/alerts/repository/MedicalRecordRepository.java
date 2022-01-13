package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.ArrayContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MedicalRecordRepository implements IMedicalRecordRepository{

    private final ArrayContainer data;
    private Set<MedicalRecord> medicalRecords = new HashSet<>();


    public MedicalRecordRepository(ArrayContainer data) {
        this.data = data;
        this.medicalRecords = this.data.getMedicalrecords();
        System.out.println(this.medicalRecords);

    }

    public Set<MedicalRecord> getAll(){
        return this.medicalRecords;
    }

    public MedicalRecord get(String firstName, String lastName){
        MedicalRecord medicalRecord = this.medicalRecords.stream().filter(medicalRecord1 ->
                medicalRecord1.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                        && medicalRecord1.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .findFirst().orElse(null);

        return medicalRecord;

    }

    public void delete(String firstName, String lastName){
        this.medicalRecords = this.medicalRecords.stream().filter(medicalRecord1 ->
                !medicalRecord1.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                && !medicalRecord1.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toSet());
    }
    public MedicalRecord save(MedicalRecord newMedicalRecord){
        boolean result = this.medicalRecords.add(newMedicalRecord);
        if(!result){
            return null;
        }
        return newMedicalRecord;
    }
    public MedicalRecord update(String firstName, String lastName, MedicalRecord update){
        MedicalRecord medicalRecord = get(firstName, lastName);
        if (medicalRecord == null){
            return null;
        }
        this.medicalRecords.remove(medicalRecord);
        this.medicalRecords.add(update);
        return update;

    }
}
