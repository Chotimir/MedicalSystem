package com.medicalsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "opis_choroby_s")
public class DiseaseDescription extends IdComparableEntity {

    @Id
    @Column(name = "id_opis_choroby")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_choroby")
    @Getter @Setter
    @JsonBackReference
    private Disease disease;

    @Column(name = "nazwa_opis_choroby", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String description;

    @Column(name = "wartosc_w_excelu")
    @Getter @Setter
    private int excelValue;

    public DiseaseDescription() {}

    public DiseaseDescription(int id, Disease disease, String description, int excelValue) {
        this.id = id;
        this.disease = disease;
        this.description = description;
        this.excelValue = excelValue;
    }
}
