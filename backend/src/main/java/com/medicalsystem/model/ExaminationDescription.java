package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "badania_s")
public class ExaminationDescription extends IdComparableEntity {

    @Id
    @Column(name = "id_badania")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_badania", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String name;

    @Column(name = "jednostka", columnDefinition = "varchar(10)")
    @Getter @Setter
    private String unit;

    public ExaminationDescription() {}

    public ExaminationDescription(int id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }
}
