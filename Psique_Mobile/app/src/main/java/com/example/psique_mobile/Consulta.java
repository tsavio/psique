package com.example.psique_mobile;

import java.util.Date;

public class Consulta {


    private String consultationID;
    private Medico doctorID;
    private String data;
    private String hour;
    private PerfilLogin patientID;


    public Consulta(String consultationID, String data, Medico doctorID, String hour, PerfilLogin patientID) {
        this.consultationID = consultationID;
        this.data = data;
        this.doctorID = doctorID;
        this.hour = hour;
        this.patientID = patientID;
    }

    public String getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(String consultationID) {
        this.consultationID = consultationID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Medico getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Medico doctorID) {
        this.doctorID = doctorID;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public PerfilLogin getPatientID() {
        return patientID;
    }

    public void setPatientID(PerfilLogin patientID) {
        this.patientID = patientID;
    }
}
