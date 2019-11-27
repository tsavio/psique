package com.example.psique_mobile;


public class  Agendamento {

    private String date;
    private String hour;
    private String name;

    @Override
    public String toString(){return name + "\n" + date + "\n" + hour;}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agendamento() {
        this.name = name;
        this.date = date;
        this.hour = hour;
    }
}