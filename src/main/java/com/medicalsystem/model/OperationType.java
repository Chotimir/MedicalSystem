package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rodzaj_zabiegu_s")
public class OperationType {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rodzaju_zabiegu")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_rodzaju_zabiegu", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

}
