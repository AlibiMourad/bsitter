/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model;

import com.khaled.bsitter.model.enums.Days;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Sitter implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @OneToOne(cascade = CascadeType.ALL)
    private Users users;
    @ElementCollection
    private List<Days> openedDay;
    @ElementCollection
    private Map<Integer,String> noteReviewCommantair;
    private double tarifPerDay;
   
}