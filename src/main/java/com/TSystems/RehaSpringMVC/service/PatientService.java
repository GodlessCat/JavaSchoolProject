package com.TSystems.RehaSpringMVC.service;

import com.TSystems.RehaSpringMVC.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> index();

    public Patient show(int id);

    public void save(Patient patient);

    public void update(int id, Patient updatePatient);
}
