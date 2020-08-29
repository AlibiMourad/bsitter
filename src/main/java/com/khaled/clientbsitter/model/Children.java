package com.khaled.clientbsitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaled.clientbsitter.model.enums.Genre;
import java.util.Date;
import lombok.Data;

@Data
public class Children {

//    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private Date DateNaissance;
    private Genre genre;
}
