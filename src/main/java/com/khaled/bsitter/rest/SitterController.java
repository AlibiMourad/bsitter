/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.khaled.bsitter.dto.SitterDTO;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.khaled.bsitter.repository.SitterJpaRepository;

@RestController
@RequestMapping("/api/sitter")
public class SitterController {

    public static final Logger logger = LoggerFactory.getLogger(SitterController.class);

    private SitterJpaRepository sitterJpaRepository;

    @Autowired
    public void setSitterRepo(SitterJpaRepository sitterJpaRepository) {
        this.sitterJpaRepository = sitterJpaRepository;
    }

    // Get All SITTER : //
    @GetMapping("/")
    public ResponseEntity<List<SitterDTO>> listAllSitter() {
        List<SitterDTO> sitter = sitterJpaRepository.findAll();
        if (sitter.isEmpty()) {
            return new ResponseEntity<List<SitterDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SitterDTO>>(sitter, HttpStatus.OK);
    }

    // Add new SITTER : //
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SitterDTO> createSitter(@Valid @RequestBody final SitterDTO sitter) {
        logger.info("Creating Sitter : {}", sitter);
        if (sitterJpaRepository.findByNcin(sitter.getNcin()) != null) {
            logger.error("Unable to create. A Sitter with ncin {} already exist",
                    sitter.getNcin());
            return new ResponseEntity<SitterDTO>(new SitterDTO(), HttpStatus.CONFLICT);
        }
        sitterJpaRepository.save(sitter);
        return new ResponseEntity<SitterDTO>(sitter, HttpStatus.CREATED);
    }

    // Get SITTER by ID : //
    @GetMapping("/{id}")
    public ResponseEntity<SitterDTO> getSitterById(@PathVariable("id") final Long id) {
        Optional<SitterDTO> sitter = sitterJpaRepository.findById(id);
        if (!sitter.isPresent()) {
            return new ResponseEntity<SitterDTO>(new SitterDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SitterDTO>(sitter.get(), HttpStatus.OK);
    }

    // Update SITTER by ID : //
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SitterDTO> updateSitter(@PathVariable("id") final Long id,
            @RequestBody SitterDTO sitter) {
        Optional<SitterDTO> currentSitter = sitterJpaRepository.findById(id);
        if (!currentSitter.isPresent()) {
            return new ResponseEntity<SitterDTO>(new SitterDTO(), HttpStatus.NOT_FOUND);
        }
        currentSitter.get().setUsers(sitter.getUsers());
        currentSitter.get().setOpenedDay(sitter.getOpenedDay());
        currentSitter.get().setNoteReviewCommantair(sitter.getNoteReviewCommantair());
        currentSitter.get().setTarifPerDay(sitter.getTarifPerDay());
        currentSitter.get().setNcin(sitter.getNcin());
      
        sitterJpaRepository.saveAndFlush(currentSitter.get());
        return new ResponseEntity<SitterDTO>(currentSitter.get(), HttpStatus.OK);
    }

    // Delete SITTER by ID : //
    @DeleteMapping("/{id}")
    public ResponseEntity<SitterDTO> deleteSitter(@PathVariable("id") final Long id) {
        Optional<SitterDTO> sitter = sitterJpaRepository.findById(id);
        if (!sitter.isPresent()) {
            return new ResponseEntity<SitterDTO>(new SitterDTO(), HttpStatus.NOT_FOUND);
        }
        sitterJpaRepository.deleteById(id);
        return new ResponseEntity<SitterDTO>(HttpStatus.NO_CONTENT);
    }
}
