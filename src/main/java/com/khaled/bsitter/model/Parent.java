/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Genre;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author alibi
 */
//@Entity
//@Data
public class Parent extends User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<Person> listChildren;
    @OneToOne(cascade = CascadeType.ALL)
    private Person partner;

//    public Parent(List<Person> listChildren, Person partner, Long id, Auth auth, String Email, List<String> Telephones, Adress adress, String firstName, String lastName, Date DateNaissance, Genre genre) {
//        super(id, auth, Email, Telephones, adress, firstName, lastName, DateNaissance, genre);
//        this.listChildren = listChildren;
//        this.partner = partner;
//    }

    public Parent(Long id, String Email, List<String> Telephones, String firstName, String lastName, Date DateNaissance, Genre genre) {
        super(id, Email, Telephones, firstName, lastName, DateNaissance, genre);
    }
    
}
