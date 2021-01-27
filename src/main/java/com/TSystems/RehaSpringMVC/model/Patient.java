package com.TSystems.RehaSpringMVC.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "patients")
@Getter @Setter @NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<Appointment> appointments;

    @NotEmpty(message = "Empty name")
    private String name;

    @NotEmpty(message = "Empty diagnoses")
    private String diagnoses;

    @NotEmpty(message = "Empty insurance number")
    private String insuranceNumber;

    @NotEmpty(message = "Empty patient status")
    private String patientStatus = "Is treated";

}
