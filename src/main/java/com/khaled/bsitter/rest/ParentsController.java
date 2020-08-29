package com.khaled.bsitter.rest;

import com.khaled.bsitter.dto.ParentsDTO;
import com.khaled.bsitter.repository.ParentsJpaRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/api/parents")
public class ParentsController {

    public static final Logger logger = LoggerFactory.getLogger(ParentsController.class);

    private ParentsJpaRepository parentsJpaRepository;

    @Autowired
    public void setParentsRepo(ParentsJpaRepository parentsJpaRepository) {
        this.parentsJpaRepository = parentsJpaRepository;
    }

    // Get All PARENTS : //
    @GetMapping("/")
    public ResponseEntity<List<ParentsDTO>> listAllParents() {
        List<ParentsDTO> parents = parentsJpaRepository.findAll();
        if (parents.isEmpty()) {
            return new ResponseEntity<List<ParentsDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ParentsDTO>>(parents, HttpStatus.OK);
    }

    // Add new PARENTS : //
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParentsDTO> createParents(@Valid @RequestBody final ParentsDTO parents) {
        logger.info("Creating Parents : {}", parents);
        if (parentsJpaRepository.findByNcin(parents.getNcin()) != null) {
            logger.error("Unable to create. A Parents with ncin {} already exist",
                    parents.getNcin());
            return new ResponseEntity<ParentsDTO>(new ParentsDTO(), HttpStatus.CONFLICT);
        }
        parentsJpaRepository.save(parents);
        return new ResponseEntity<ParentsDTO>(parents, HttpStatus.CREATED);
    }

    // Get PARENTS by ID : //
    @GetMapping("/{id}")
    public ResponseEntity<ParentsDTO> getParentsById(@PathVariable("id") final Long id) {
        Optional<ParentsDTO> parents = parentsJpaRepository.findById(id);
        if (!parents.isPresent()) {
            return new ResponseEntity<ParentsDTO>(new ParentsDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ParentsDTO>(parents.get(), HttpStatus.OK);
    }

    // Update PARENTS by ID : //
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParentsDTO> updateParents(@PathVariable("id") final Long id,
            @RequestBody ParentsDTO parents) {
        Optional<ParentsDTO> currentParents = parentsJpaRepository.findById(id);
        if (!currentParents.isPresent()) {
            return new ResponseEntity<ParentsDTO>(new ParentsDTO(), HttpStatus.NOT_FOUND);
        }
        currentParents.get().setNcin(parents.getNcin());
        currentParents.get().setListChildren(parents.getListChildren());
        currentParents.get().setIdSitter(parents.getIdSitter());

        parentsJpaRepository.saveAndFlush(currentParents.get());
        return new ResponseEntity<ParentsDTO>(currentParents.get(), HttpStatus.OK);
    }

    // Delete PARENTS by ID : //
    @DeleteMapping("/{id}")
    public ResponseEntity<ParentsDTO> deleteParents(@PathVariable("id") final Long id) {
        Optional<ParentsDTO> parents = parentsJpaRepository.findById(id);
        if (!parents.isPresent()) {
            return new ResponseEntity<ParentsDTO>(new ParentsDTO(), HttpStatus.NOT_FOUND);
        }
        parentsJpaRepository.deleteById(id);
        return new ResponseEntity<ParentsDTO>(HttpStatus.NO_CONTENT);
    }
}
