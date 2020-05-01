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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author alibi
 */
@Entity
@Data
public class Parent extends User{
    
    
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<Person> listChildren;

    public Parent(List<Person> listChildren, Auth auth, String Email, List<String> Telephones, Adress adress, Long id, String firstName, String lastName, Date DateNaissance, Genre genre, Parent parent) {
        super(auth, Email, Telephones, adress, id, firstName, lastName, DateNaissance, genre, parent);
        this.listChildren = listChildren;
    }

 

  

}
