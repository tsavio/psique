package com.example.psique_mobile;


public class  Agendamento {

    private String id;
    private String doctorName;
    private String date;
    private String hour;



    @Override
    public String toString(){return doctorName + "\n" + "Data: " + date + " "+ "Hora: " + hour;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
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

    public Agendamento(){
        this.hour = hour;
        this.id = id;
        this.date = date;
        this.doctorName = doctorName;

    }

}