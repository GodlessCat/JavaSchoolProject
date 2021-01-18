package com.TSystems.RehaSpringMVC.controllers;

import com.TSystems.RehaSpringMVC.dao.PatientsDAO;
import com.TSystems.RehaSpringMVC.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientsController {

    private final PatientsDAO patientsDAO;

    @Autowired
    public PatientsController(PatientsDAO patientsDAO) {
        this.patientsDAO = patientsDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("patients", patientsDAO.index());
        return "patients/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("patient", patientsDAO.show(id));
        return "patients/show";
    }

    @GetMapping("/new")
    public String newPatient(@ModelAttribute("patient") Patient patient){
        return "patients/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("patient") Patient patient){
        patientsDAO.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("patient", patientsDAO.show(id));
        return "patients/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("patient") Patient patient, @PathVariable("id") int id){
        patientsDAO.update(id, patient);
        return "redirect:/patients";
    }
}
