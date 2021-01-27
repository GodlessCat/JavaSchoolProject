package com.TSystems.RehaSpringMVC.service;

import com.TSystems.RehaSpringMVC.dao.AppointmentDAO;
import com.TSystems.RehaSpringMVC.dao.AppointmentDAOImpl;
import com.TSystems.RehaSpringMVC.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDAO appointmentDAO  = new AppointmentDAOImpl();

    @Override
    @Transactional
    public List<Appointment> index() {
        return appointmentDAO.index();
    }

    @Override
    @Transactional
    public void add(Appointment appointment) {
        appointmentDAO.add(appointment);
    }
}
