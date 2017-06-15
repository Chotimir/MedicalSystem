package com.medicalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tryb_zabiegu_s")
public class OperationMode extends IdComparableEntity {

    @Id
    @Column(name = "tryb_zabiegu")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_trybu_zabiegu", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String name;

    public OperationMode() {}

    public OperationMode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
