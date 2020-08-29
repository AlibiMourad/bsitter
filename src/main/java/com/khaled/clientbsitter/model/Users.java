package com.khaled.clientbsitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaled.clientbsitter.model.enums.Genre;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Users {

//    @JsonIgnore
    private Long id;
    private Auth auth;
    private String firstName;
    private String lastName;
    private Date DateNaissance;
    private String genre;
    private String email;
    private List<String> Telephones = new ArrayList<>();
    private Adress adress;
}
