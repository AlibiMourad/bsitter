/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.khaled.bsitter.model.Sitter;
import com.khaled.bsitter.repository.SitterRepo;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/sitter")
public class SitterController {

    public static final Logger logger = LoggerFactory.getLogger(SitterController.class);
 
    private SitterRepo sitterRepo;

        
    	@Autowired
          public void setSitterRepo(SitterRepo sitterRepo) {
                this.sitterRepo = sitterRepo;
        }

        
	// Get All SITTER : //
          @GetMapping("/")
	public ResponseEntity<List<Sitter>> listAllSitter(){
		List<Sitter> sitter = sitterRepo.findAll();
/*		if(sitters.isEmpty()) {	
		}*/
	return new ResponseEntity<List<Sitter>>(sitter, HttpStatus.OK);

	}
        
        // Add new USER : //
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sitter> createSitter(@Valid @RequestBody final Sitter sitter) {
           // logger.info("Creating Sitter : {}", sitter);
                
//		if(sitterRepository.findByUserName(sitter.getSitter().getUserName()) != null) {
//			logger.error("Unable to create. A Sitter with name {} already exist",
//					sitter.getSitter().getUserName());
//		}
            
		sitterRepo.save(sitter);
//		userJpaRepository.save(user);
		return new ResponseEntity<Sitter>(sitter, HttpStatus.CREATED);
	}
//	
//	// Get USER by ID : //
//	public Sitter getSitterById(Long id){
//		Optional<Sitter> sitter = sitterRepository.findById(id);
////		if(! sitter.isPresent()) {
////		}
//		return sitter.get();			
//	}
//	
//	public Sitter updateSitter(Long id, Sitter sitter) {
//		Optional<Sitter> currentSitter  = sitterRepository.findById(id);
////		if(! currentSitter.isPresent()) {
////		}
//		currentSitter.get().setFirstName(sitter.getFirstName());
//                currentSitter.get().setLastName(sitter.getLastName());
//                currentSitter.get().setDateNaissance(sitter.getDateNaissance());
//                currentSitter.get().setGenre(sitter.getGenre());
//                
//                currentSitter.get().setSitter(sitter.getSitter());
//                currentSitter.get().setEmail(sitter.getEmail());
//                currentSitter.get().setTelephones(sitter.getTelephones());
//                currentSitter.get().setAdress(sitter.getAdress());
//
//		sitterRepository.saveAndFlush(currentSitter.get());
//		return currentSitter.get();
//	}
//	
//	public boolean deleteSitter(Long id) {
//		Optional<Sitter> sitter = sitterRepository.findById(id);
////		if(! sitter.isPresent()) {	
////		}
//		sitterRepository.deleteById(id);
//		return true;
//	}

  
        
}
