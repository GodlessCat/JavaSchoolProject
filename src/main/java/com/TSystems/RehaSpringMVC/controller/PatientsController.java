package com.TSystems.RehaSpringMVC.controller;

import com.TSystems.RehaSpringMVC.model.Patient;
import com.TSystems.RehaSpringMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/patients")
public class PatientsController {

    private PatientService patientService;

    @Autowired
    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("patients", patientService.index());
        return "patients/index";
    }

    @GetMapping("/new")
    public String newPatient(@ModelAttribute("patient") Patient patient){
        return "patients/newPatient";
    }

    @PostMapping()
    public String create(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "patients/newPatient";
        }

        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("patient", patientService.show(id));
        return "patients/editPatient";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult,
                         @PathVariable("id") int id){

        if (bindingResult.hasErrors()){
            return "patients/editPatient";
        }

        patientService.update(id, patient);
        return "redirect:/patients";
    }
}
