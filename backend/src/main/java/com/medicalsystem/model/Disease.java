package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "choroby_s")
public class Disease {

    @Id
    @Column(name = "id_choroby")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_choroby", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "disease", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<DiseaseDescription> descriptions;

    public Disease() {}

    public Disease(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
