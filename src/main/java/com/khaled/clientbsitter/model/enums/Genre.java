package com.khaled.clientbsitter.model.enums;


public enum Genre {
    M("homme"),
    F("femme");
    
    private String genre;

    private Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
 
}
