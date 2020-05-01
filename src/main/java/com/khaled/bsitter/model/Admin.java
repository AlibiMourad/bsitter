/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Genre;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alibi
 */
//@Entity
//@Data
public class Admin  extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    public Admin(Long id, Auth auth, String Email, List<String> Telephones, Adress adress, String firstName, String lastName, Date DateNaissance, Genre genre) {
//        super(id, auth, Email, Telephones, adress, firstName, lastName, DateNaissance, genre);
//    }

    public Admin(Long id, String Email, List<String> Telephones, String firstName, String lastName, Date DateNaissance, Genre genre) {
        super(id, Email, Telephones, firstName, lastName, DateNaissance, genre);
    }
    
}
