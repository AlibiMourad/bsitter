package com.khaled.clientbsitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaled.clientbsitter.model.enums.Pays;
import lombok.Data;

@Data
public class Adress {

//    @JsonIgnore
    private Long id;
    private Pays pays;
    private String ville;
    private String postal;

}
