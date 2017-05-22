package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "leki_s")
public class Medicament {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_leku")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_leku", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

}
