package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "powiklania_s")
public class Complication {

    @Id
    @Column(name = "id_powiklania")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_powiklania", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "complication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter @Setter
    private ComplicationDescription description;

    public Complication() {}

    public Complication(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
