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
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author alibi
 */
@Entity
@Data
public class User extends Person{
       
    @OneToOne(cascade = CascadeType.ALL)
    private Auth auth;
    private String Email;
    @ElementCollection
    private List<String> Telephones;
    @OneToOne(cascade = CascadeType.ALL)
    private Adress adress;

    public User(Auth auth, String Email, List<String> Telephones, Adress adress, Long id, String firstName, String lastName, Date DateNaissance, Genre genre, Parent parent) {
        super(id, firstName, lastName, DateNaissance, genre, parent);
        this.auth = auth;
        this.Email = Email;
        this.Telephones = Telephones;
        this.adress = adress;
    }


   
}
