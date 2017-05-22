package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "przyczyna_ponownego_przyjecia_s")
public class RevisitCause {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "przyczyna_ponownego_przyjecia")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_przyczyny", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

}
