package com.khaled.clientbsitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import lombok.Data;

@Data
public class HistoryLog {

//    @JsonIgnore
    private Long id;
    private boolean seccusLogin;
    private Date dateLog;
}
