/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.repository;

import com.khaled.bsitter.model.Sitter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SitterRepo  extends JpaRepository<Sitter, Long> {
    
}
