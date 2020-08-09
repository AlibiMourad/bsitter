/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.dto.enums;

/**
 *
 * @author alibi
 */
public enum Genre {
    H("Homme"),
    F("femme");
    
    private String genre;

    private Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
 
}
