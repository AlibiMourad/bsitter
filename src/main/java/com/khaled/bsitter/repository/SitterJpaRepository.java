/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.repository;

import com.khaled.bsitter.dto.SitterDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SitterJpaRepository  extends JpaRepository<SitterDTO, Long> {
    SitterDTO findByNcin(String ncin);
}
