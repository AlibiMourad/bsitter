package com.khaled.clientbsitter.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Parents {

    private Long id;
    private String ncin;

    private Users users;

    private List<Children> listChildren = new ArrayList<>();

    private Sitter sitter;

}
