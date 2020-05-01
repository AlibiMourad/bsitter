/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Pays;
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
public class Adress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Pays pays;
    private String Ville;
    private String postal;
    @OneToOne
    @MapsId
    private User user;
    
    public Adress() {
    }
    public Adress(Pays pays, String Ville, String postal) {
        this.pays = pays;
        this.Ville = Ville;
        this.postal = postal;
    }
}
