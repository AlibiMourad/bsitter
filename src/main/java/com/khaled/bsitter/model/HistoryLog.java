/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.khaled.bsitter.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author alibi
 */
@Entity
@Data
public class HistoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean seccusLogin;
    private Date dateLog;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Auth auth;
    
    public HistoryLog(boolean seccusLogin, Date dateLog) {
        this.seccusLogin = seccusLogin;
        this.dateLog = dateLog;
    }

}
