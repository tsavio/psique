package com.example.psique_mobile;

import android.provider.ContactsContract;

import java.util.Date;

public class Consulta {


    private String consultationID;
    private Doctor doctorID;
    private String doctorName;
    private String date;
    private String hour;
    private Pessoa patientID;
    private String anamnese;


    @Override
    public String toString(){return doctorName +  "\n" + date + " - "+ hour;}

    public Consulta(){

    }

    public Consulta(String consultationID, String date, Doctor doctorID, String doctorName, String hour, Pessoa patientID, String anamnese) {
        this.consultationID = consultationID;
        this.date = date;
        this.doctorName = doctorName;
        this.doctorID = doctorID;
        this.hour = hour;
        this.patientID = patientID;
        this.anamnese = anamnese;
    }

    public String getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(String consultationID) {
        this.consultationID = consultationID;
    }

    public String getDate() {
        return date;
    }

    public void setData(String date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Doctor getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Doctor doctorID) {
        this.doctorID = doctorID;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Pessoa getPatientID() {
        return patientID;
    }

    public void setPatientID(Pessoa patientID) {
        this.patientID = patientID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

}
