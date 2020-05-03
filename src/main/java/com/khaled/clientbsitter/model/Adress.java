package com.khaled.clientbsitter.model;

import com.khaled.clientbsitter.model.enums.Pays;
import lombok.Data;

@Data
public class Adress {

    private Long id;
    private Pays pays;
    private String ville;
    private String postal;

}
