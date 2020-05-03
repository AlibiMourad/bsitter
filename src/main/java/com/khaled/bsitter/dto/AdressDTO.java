/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.khaled.bsitter.dto;

import com.khaled.bsitter.dto.enums.Pays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


/**
 *
 * @author alibi 
 */
@Entity(name = "Adress")
@Table(name = "Adress")
@Data
public class AdressDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Pays pays;
    private String ville;
    private String postal;

    
}
