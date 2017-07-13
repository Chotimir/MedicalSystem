package com.medicalsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicalsystem.serialization.PatientSexSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dane_osobowe")
public class Patient extends IdComparableEntity {

    @Id
    @Column(name = "id_pacjenta")
    @JsonIgnore
    @Getter @Setter
    private int id;

    @Column(name = "imie", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String firstName;

    @Column(name = "nazwisko", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String lastName;

    @Column(name = "plec", columnDefinition = "varchar(1)")
    @Getter @Setter
    @JsonSerialize(using = PatientSexSerializer.class)
    private String sex;

    @Column(name = "wiek")
    @Getter @Setter
    private int age;

    @ManyToMany
    @JoinTable(
            name = "choroby_wspolistniejace",
            joinColumns = @JoinColumn(name = "id_pacjenta", referencedColumnName = "id_pacjenta"),
            inverseJoinColumns = @JoinColumn(name = "id_opis_choroby", referencedColumnName = "id_opis_choroby")
    )
    @JsonIgnore
    @Getter @Setter
    private List<DiseaseDescription> diseaseDescriptions;

}
