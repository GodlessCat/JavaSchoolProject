package com.TSystems.RehaSpringMVC.service;

import com.TSystems.RehaSpringMVC.model.Appointment;

import java.util.List;

public interface AppointmentService {
    public List<Appointment> index();
    public void add(Appointment appointment);
}
