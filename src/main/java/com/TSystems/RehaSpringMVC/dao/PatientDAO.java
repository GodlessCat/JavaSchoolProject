package com.TSystems.RehaSpringMVC.dao;

import com.TSystems.RehaSpringMVC.model.Patient;

import java.util.List;

public interface PatientDAO {
    public List<Patient> index();

    public Patient getById(int id);

    public void add(Patient patient);

    public void edit(int id, Patient updatePatient);
}
