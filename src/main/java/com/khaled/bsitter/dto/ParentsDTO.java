package com.khaled.bsitter.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "Parents")
@Table(name = "Parents")
@Data
public class ParentsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ncin;
    @OneToOne(cascade = CascadeType.ALL)
    private UsersDTO users;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ChildrenDTO> listChildren = new ArrayList<>();
//    @OneToOne(cascade = CascadeType.ALL)
//    private SitterDTO sitter;
    private Long idSitter;

}
