package com.TSystems.RehaSpringMVC.dao;

import com.TSystems.RehaSpringMVC.model.Appointment;

import java.util.List;

public interface AppointmentDAO {
    public List<Appointment> index();
    public void add(Appointment appointment);
}
