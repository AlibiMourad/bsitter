/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.repository;

import com.khaled.bsitter.dto.ParentsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author xfrag
 */
public interface ParentsJpaRepository  extends JpaRepository<ParentsDTO, Long> {
    ParentsDTO findByNcin(String ncin);
}
