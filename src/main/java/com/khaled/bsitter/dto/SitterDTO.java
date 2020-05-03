/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.dto;

import com.khaled.bsitter.dto.enums.Days;
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
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "Sitter")
@Table(name = "Sitter")
@Data
public class SitterDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private UsersDTO users;
    @ElementCollection
    private List<Days> openedDay;
    @ElementCollection
    private Map<Integer, String> noteReviewCommantair;
    private double tarifPerDay;
    private String ncin;

    @OneToOne(cascade = CascadeType.ALL)
    private ParentsDTO parents;
}
