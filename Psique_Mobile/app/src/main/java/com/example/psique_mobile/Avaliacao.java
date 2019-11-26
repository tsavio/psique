package com.example.psique_mobile;

public class Avaliacao {

    private String id;
    private int rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Avaliacao(String id, int rating){
        this.id = id;
        this.rating = rating;
    }
}
