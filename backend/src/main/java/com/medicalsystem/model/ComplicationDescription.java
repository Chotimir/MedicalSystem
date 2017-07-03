package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "opis_powiklania_s")
public class ComplicationDescription extends IdComparableEntity {

    @Id
    @Column(name = "id_opis_powiklania")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_powiklania")
    @Getter @Setter
    private Complication complication;

    @Column(name = "nazwa_opis_powiklania", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String description;

    @Column(name = "wartosc_w_excelu")
    @Getter @Setter
    private int excelValue;

    public ComplicationDescription() {}

    public ComplicationDescription(int id, Complication complication, String description, int excelValue) {
        this.id = id;
        this.complication = complication;
        this.description = description;
        this.excelValue = excelValue;
    }
}
