package com.medicalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "badania_przy_przyjeciu")
public class Examination extends IdComparableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_badania_przy_przyjeciu")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia")
    @Getter @Setter
    private Admission admission;

    @OneToOne
    @JoinColumn(name = "id_badania")
    @Getter @Setter
    private ExaminationDescription description;

    @Column(name = "wynik_badania")
    @Getter @Setter
    private float result;

}
