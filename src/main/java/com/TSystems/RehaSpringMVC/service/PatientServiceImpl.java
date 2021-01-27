package com.TSystems.RehaSpringMVC.service;

import com.TSystems.RehaSpringMVC.dao.PatientDAO;
import com.TSystems.RehaSpringMVC.dao.PatientDAOImpl;
import com.TSystems.RehaSpringMVC.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientsDAO = new PatientDAOImpl();

    @Override
    @Transactional
    public List<Patient> index() {
        return patientsDAO.index();
    }

    @Override
    @Transactional
    public Patient show(int id) {
        return patientsDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Patient patient) {
        patientsDAO.add(patient);
    }

    @Override
    @Transactional
    public void update(int id, Patient updatePatient) {
        patientsDAO.edit(id, updatePatient);
    }
}
