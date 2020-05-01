/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.khaled.bsitter.model;

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
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private Date dateCreation;
    @OneToMany(mappedBy = "auth", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<HistoryLog> hisLog;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private int active;

    public Auth(String userName, String password, Date dateCreation, 
        List<HistoryLog> hisLog, int active) {
        this.userName = userName;
        this.password = password;
        this.dateCreation = dateCreation;
        this.hisLog = hisLog;
        this.active = active;
    }

    }

