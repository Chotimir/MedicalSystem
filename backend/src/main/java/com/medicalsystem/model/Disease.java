package com.medicalsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "choroby_s")
public class Disease extends IdComparableEntity {

    @Id
    @Column(name = "id_choroby")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_choroby", columnDefinition = "varchar(50)")
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "disease", cascade = CascadeType.ALL)
    @Getter @Setter
    @JsonManagedReference
    private List<DiseaseDescription> descriptions;

    public Disease() {}

    public Disease(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
