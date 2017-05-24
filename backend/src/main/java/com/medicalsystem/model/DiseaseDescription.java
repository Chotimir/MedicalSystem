package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "opis_choroby_s")
public class DiseaseDescription {

    @Id
    @Column(name = "id_opis_choroby")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_choroby", nullable = false)
    @Getter @Setter
    private Disease disease;

    @Column(name = "nazwa_opis_choroby", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String description;

    public DiseaseDescription() {}

    public DiseaseDescription(int id, Disease disease, String description) {
        this.id = id;
        this.disease = disease;
        this.description = description;
    }
}
