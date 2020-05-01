/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Genre;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author alibi
 */
//@Entity
//@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date DateNaissance;
    private Genre genre;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Parent parent;
    public Person(String firstName, String lastName, Date DateNaissance, Genre genre) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateNaissance = DateNaissance;
        this.genre = genre;
    }
     
}
