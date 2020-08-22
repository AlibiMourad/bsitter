package com.khaled.clientbsitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaled.clientbsitter.model.enums.Days;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Sitter {

//    @JsonIgnore
    private Long id;
    private Users users;
    private List<Days> openedDay;
    private Map<Integer, String> noteReviewCommantair;
    private double tarifPerDay;
    private String ncin;
    private Parents parents;
}
