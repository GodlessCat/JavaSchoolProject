package com.TSystems.RehaSpringMVC.models;

public class Patient {
    private int id;
    private String name;
    private String diagnoses;
    private String insuranceNumber;
    private String patientStatus;

    public Patient(int id, String name, String diagnosis, String insuranceNumber, String patientStatus) {
        this.id = id;
        this.name = name;
        this.diagnoses = diagnosis;
        this.insuranceNumber = insuranceNumber;
        this.patientStatus = patientStatus;
    }

    public Patient() {
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
