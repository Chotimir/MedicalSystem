package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "palenie_tytoniu_s")
public class Smoking {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "palenie_tytoniu")
    @Getter @Setter
    private int id;

    @Column(name = "wartosc_tekstowa", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String text;

}
