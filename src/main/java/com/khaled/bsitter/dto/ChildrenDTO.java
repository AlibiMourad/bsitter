/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.dto;

import com.khaled.bsitter.dto.enums.Genre;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "Children")
@Table(name = "Children")
@Data
public class ChildrenDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private String firstName;
    private String lastName;
    private Date DateNaissance;
    private Genre genre;
}
