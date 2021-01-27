package com.TSystems.RehaSpringMVC.dao;

import com.TSystems.RehaSpringMVC.model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppointmentDAO")
public class AppointmentDAOImpl implements AppointmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Appointment> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Appointment ").list();
    }

    @Override
    public void add(Appointment appointment) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(appointment);
    }
}
