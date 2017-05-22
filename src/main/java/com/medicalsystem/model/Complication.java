package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "powiklania_s")
public class Complication {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_powiklania")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_powiklania", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

}
