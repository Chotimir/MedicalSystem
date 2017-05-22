package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "choroby_s")
public class Disease {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_choroby")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_choroby", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

    @ManyToMany(mappedBy = "diseases")
    @Getter @Setter
    private List<Patient> patients;

}
