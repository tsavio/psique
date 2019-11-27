package com.example.psique_mobile;


public class Agendamento {

    private String date;
    private String hour;
    private String doctorName;
    private String doctorId;



    @Override
    public String toString(){return "Doutor: " + doctorName + "\n" +  "Data: " + date + "\n" + "Horario: " + hour;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorNamename) {
        this.doctorName = doctorName;
    }
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Agendamento() {
        this.doctorName = doctorName;
        this.date = date;
        this.hour = hour;
        this.doctorId = doctorId;
    }
}