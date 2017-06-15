package com.medicalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "przyczyna_ponownego_przyjecia_s")
public class RevisitCause extends IdComparableEntity {

    @Id
    @Column(name = "przyczyna_ponownego_przyjecia")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_przyczyny", columnDefinition = "varchar(70)")
    @Getter @Setter
    private String name;

    public RevisitCause() {}

    public RevisitCause(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
