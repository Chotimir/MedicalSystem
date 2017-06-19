package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "badania_przy_przyjeciu")
public class Examination {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_badania_przy_przyjeciu")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia", nullable = false)
    @Getter @Setter
    private Admission admission;

    @OneToOne
    @JoinColumn(name = "id_badania", nullable = false)
    @Getter @Setter
    private ExaminationDescription description;

    @Column(name = "wynik_badania", nullable = false)
    @Getter @Setter
    private float result;

}