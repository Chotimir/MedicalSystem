package com.medicalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "leki_s")
public class Medicament extends IdComparableEntity {

    @Id
    @Column(name = "id_leku")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_leku", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String name;

    public Medicament() {}

    public Medicament(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
