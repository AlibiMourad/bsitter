package com.khaled.clientbsitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Auth {

//    @JsonIgnore
    private Long id;
    private String userName;
    private String password;
    private Date dateCreation;
    private List<HistoryLog> hisLog = new ArrayList<>();
    private int active;

}
