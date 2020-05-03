package com.khaled.clientbsitter.model;

import java.util.Date;
import lombok.Data;

@Data
public class HistoryLog {

    private Long id;
    private boolean seccusLogin;
    private Date dateLog;
}
