package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "opis_choroby_s")
public class DiseaseDescription {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_opis_choroby")
    @Getter @Setter
    private int id;

    @OneToOne
    @JoinColumn(name = "id_choroby", nullable = false)
    @Getter @Setter
    private Disease disease;

    @Column(name = "nazwa_opis_choroby", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String description;

}
