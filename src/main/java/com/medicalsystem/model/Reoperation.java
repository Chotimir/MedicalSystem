package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reoperacja_s")
public class Reoperation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reoperacja")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_reoperacji", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

}
