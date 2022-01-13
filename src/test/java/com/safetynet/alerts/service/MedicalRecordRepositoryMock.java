package com.safetynet.alerts.service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.IMedicalRecordRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MedicalRecordRepositoryMock implements IMedicalRecordRepository {

    private Set<MedicalRecord> medicalRecords = new HashSet<>();

    public MedicalRecordRepositoryMock() {
        init();
    }

    private void init(){

        String medication = "aznol:350mg";
        String medication2 = "hydrapermazol:100mg";
        String medication3 = "pharmacol:5000mg";
        String medication4 = "terazine:10mg";
        String medication5 = "noznazol:250mg";
        String medication6 = "tetracyclaz:650mg";
        String medication7 = "dodoxadin:30mg";

        Set<String> medications = new HashSet<String>(){{
        add(medication);
        add(medication2);
        add(medication3);
        add(medication4);
        add(medication5);
        add(medication6);
        add(medication7);
        }};

        String allergie = "peanut";
        String allergie2 = "shellfish";
        String allergie3 = "aznol";
        String allergie4 = "illisoxian";
        String allergie5 = "xilliathal";

        Set<String> allergies = new HashSet<String>(){{
            add(allergie);
            add(allergie2);
            add(allergie3);
            add(allergie4);
            add(allergie5);

        }};



        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecord.setMedications(medications);
        medicalRecord.setAllergies(allergies);

        MedicalRecord medicalRecord2 = new MedicalRecord();
        medicalRecord2.setFirstName("Clive");
        medicalRecord2.setLastName("Ferguson");
        medicalRecord2.setBirthdate("03/06/1994");
        medicalRecord2.setMedications(medications);
        medicalRecord2.setAllergies(allergies);

        MedicalRecord medicalRecord3 = new MedicalRecord();
        medicalRecord3.setFirstName("Kendrik");
        medicalRecord3.setLastName("Stelzer");
        medicalRecord3.setBirthdate("03/06/2014");
        medicalRecord3.setMedications(medications);
        medicalRecord3.setAllergies(allergies);


        MedicalRecord medicalRecord4 = new MedicalRecord();
        medicalRecord4.setFirstName("Shawna");
        medicalRecord4.setLastName("Stelzer");
        medicalRecord4.setBirthdate("07/08/1980");
        medicalRecord4.setMedications(medications);
        medicalRecord4.setAllergies(allergies);


        medicalRecords = new HashSet<MedicalRecord>(){{

            add(medicalRecord);
            add(medicalRecord2);
            add(medicalRecord3);
            add(medicalRecord4);
        }
        };


    }

    @Override
    public Set<MedicalRecord> getAll() {
       return medicalRecords;
    }

    @Override
    public MedicalRecord get(String firstName, String lastName) {
        MedicalRecord medicalRecord = this.medicalRecords.stream().filter(medicalRecord1 ->
                medicalRecord1.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                        && medicalRecord1.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .findFirst().orElse(null);

        return medicalRecord;
    }

    @Override
    public void delete(String firstName, String lastName) {
        this.medicalRecords = this.medicalRecords.stream().filter(medicalRecord1 ->
                !medicalRecord1.getFirstName().toLowerCase().equals(firstName.toLowerCase())
                        && !medicalRecord1.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toSet());
    }

    @Override
    public MedicalRecord save(MedicalRecord newMedicalRecord) {
        boolean result = this.medicalRecords.add(newMedicalRecord);
        if(!result){
            return null;
        }
        return newMedicalRecord;
    }

    @Override
    public MedicalRecord update(String firstName, String lastName, MedicalRecord update) {
        MedicalRecord medicalRecord = get(firstName, lastName);
        if (medicalRecord == null){
            return null;
        }
        this.medicalRecords.remove(medicalRecord);
        this.medicalRecords.add(update);
        return update;
    }
}
