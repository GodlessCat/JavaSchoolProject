package com.TSystems.RehaSpringMVC.dao;

import com.TSystems.RehaSpringMVC.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PatientDAO")
public class PatientDAOImpl implements PatientDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Patient> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Patient").list();
    }

    public Patient getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Patient.class, id);
    }

    public void add(Patient patient) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(patient);
    }

    public void edit(int id, Patient updatePatient) {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatePatient);
    }
}