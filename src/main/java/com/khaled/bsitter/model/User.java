/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Genre;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author alibi
 */
@Entity
@Data
public class User extends Person implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
//    @OneToOne(cascade = CascadeType.ALL)
//    private Auth auth;
    private String Email;
    @ElementCollection
    private List<String> Telephones;
    @OneToOne
    @MapsId
    private Adress adress;

    public User(Long id, /*Auth auth,*/ String Email, List<String> Telephones, 
            /*Adress adress,*/ String firstName, String lastName, Date DateNaissance, Genre genre) {
        super(firstName, lastName, DateNaissance, genre);
        this.id = id;
        //this.auth = auth;
        this.Email = Email;
        this.Telephones = Telephones;
       // this.adress = adress;
    }

   
}
