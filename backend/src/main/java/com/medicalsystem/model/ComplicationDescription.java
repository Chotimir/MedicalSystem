package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "opis_powiklania_s")
public class ComplicationDescription {

    @Id
    @Column(name = "id_opis_powiklania")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_powiklania", nullable = false)
    @Getter @Setter
    private Complication complication;

    @Column(name = "nazwa_opis_powiklania", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String description;

    public ComplicationDescription() {}

    public ComplicationDescription(int id, Complication complication, String description) {
        this.id = id;
        this.complication = complication;
        this.description = description;
    }
}
