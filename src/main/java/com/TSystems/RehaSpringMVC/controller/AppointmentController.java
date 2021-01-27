package com.TSystems.RehaSpringMVC.controller;

import com.TSystems.RehaSpringMVC.model.Appointment;
import com.TSystems.RehaSpringMVC.model.Patient;
import com.TSystems.RehaSpringMVC.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("appointments", appointmentService.index());
        return "appointments/index";
    }

    @GetMapping("/newAppointment/{id}")
    public String newAppointment(@ModelAttribute("appointment") Appointment appointment) {
        return "appointments/newAppointment";
    }

    @PostMapping()
    public String create(@ModelAttribute("appointment") @Valid Appointment appointment, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "appointments/newAppointment";
        }

        appointmentService.add(appointment);
        return "redirect:/appointments";
    }
}
