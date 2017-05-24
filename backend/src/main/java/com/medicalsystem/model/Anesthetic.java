package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lek_znieczulajacy_s")
public class Anesthetic {

    @Id
    @Column(name = "lek_znieczulajacy")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_leku_znieczulajacego", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

    public Anesthetic() {}

    public Anesthetic(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
