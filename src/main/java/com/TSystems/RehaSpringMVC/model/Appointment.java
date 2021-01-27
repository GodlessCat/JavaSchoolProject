package com.TSystems.RehaSpringMVC.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "appointments")
@Getter @Setter @NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotEmpty(message = "Empty type")
    private String type;

    @NotEmpty(message = "Empty time")
    private String time;

    @NotEmpty(message = "Empty dose")
    private String dose;

}
