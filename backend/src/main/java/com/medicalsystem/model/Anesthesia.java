package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "znieczulenie_s")
public class Anesthesia extends IdComparableEntity {

    @Id
    @Column(name = "znieczulenie")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_znieczulenia", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String name;

    public Anesthesia() {}

    public Anesthesia(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
