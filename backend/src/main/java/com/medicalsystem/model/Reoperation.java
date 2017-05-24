package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reoperacja_s")
public class Reoperation {

    @Id
    @Column(name = "reoperacja")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_reoperacji", columnDefinition = "varchar(100)", nullable = false)
    @Getter @Setter
    private String name;

    public Reoperation() {}

    public Reoperation(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
