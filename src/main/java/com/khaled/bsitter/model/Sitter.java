/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Days;
import com.khaled.bsitter.model.enums.Genre;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;


/**
 *
 * @author alibi
 */
//@Entity
//@Data
public class Sitter extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Days> openedDay;
    private Map<Integer,String> NoteReviewCommantair;
    private double tarifPerDay;

    public Sitter(List<Days> openedDay, Map<Integer, String> NoteReviewCommantair, double tarifPerDay, Long id, Auth auth, String Email, List<String> Telephones, Adress adress, String firstName, String lastName, Date DateNaissance, Genre genre) {
        super(id, auth, Email, Telephones, adress, firstName, lastName, DateNaissance, genre);
        this.openedDay = openedDay;
        this.NoteReviewCommantair = NoteReviewCommantair;
        this.tarifPerDay = tarifPerDay;
    }

}
