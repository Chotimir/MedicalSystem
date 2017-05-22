package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "badania_s")
public class ExaminationDescription {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_badania")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_badania", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "jednostka", columnDefinition = "varchar(10)", nullable = false)
    @Getter @Setter
    private String unit;

}
