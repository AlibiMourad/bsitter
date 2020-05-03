package com.khaled.clientbsitter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Users {

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
