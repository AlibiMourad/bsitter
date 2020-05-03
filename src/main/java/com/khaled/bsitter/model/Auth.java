/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.khaled.bsitter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;


/**
 *
 * @author alibi
 */

@Entity
@Data
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<HistoryLog> hisLog  = new ArrayList<>();
    private int active;

    }

