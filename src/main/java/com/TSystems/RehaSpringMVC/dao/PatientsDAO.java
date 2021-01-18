package com.TSystems.RehaSpringMVC.dao;

import com.TSystems.RehaSpringMVC.models.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientsDAO {
    private static int PATIENT_COUNT;
    private List<Patient> patients;

    {
        patients = new ArrayList<>();
        patients.add(new Patient(++PATIENT_COUNT, "Alex", "Cold", "AAA0123456789", "Is treated"));
        patients.add(new Patient(++PATIENT_COUNT, "Anton", "Injury", "BBB0123456789", "Is treated"));
        patients.add(new Patient(++PATIENT_COUNT, "Andrey", "Fracture", "CCC0123456789", "Is treated"));
        patients.add(new Patient(++PATIENT_COUNT, "Anastasia", "Angina", "DDD0123456789", "Is treated"));
    }

    public List<Patient> index(){
        return patients;
    }

    public Patient show(int id){
        return patients.stream().filter(patient -> patient.getId() == id).findAny().orElse(null);
    }

    public void save(Patient patient) {
        patient.setId(++PATIENT_COUNT);
        patient.setPatientStatus("Is treated");
        patients.add(patient);
    }

    public void update(int id, Patient updatePatient) {
        Patient patientToUpdate = show(id);
        patientToUpdate.setName(updatePatient.getName());
        patientToUpdate.setDiagnoses(updatePatient.getDiagnoses());
        patientToUpdate.setInsuranceNumber(updatePatient.getInsuranceNumber());
    }
}