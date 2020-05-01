/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Genre;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author alibi
 */
@Entity
@Data
public class Admin  extends User{

    public Admin(Auth auth, String Email, List<String> Telephones, Adress adress, Long id, String firstName, String lastName, Date DateNaissance, Genre genre, Parent parent) {
        super(auth, Email, Telephones, adress, id, firstName, lastName, DateNaissance, genre, parent);
    }

 
}
