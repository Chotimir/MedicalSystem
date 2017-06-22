package com.medicalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "troponiny")
public class Troponin extends IdComparableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_troponiny")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia")
    @Getter @Setter
    private Admission admission;

    @Column(name = "tnt")
    @Getter @Setter
    private float tnt;

    @Column(name = "tni_ultra")
    @Getter @Setter
    private float tniUltra;

    @Column(name = "tni")
    @Getter @Setter
    private float tni;

    @Column(name = "tnt_doba")
    @Getter @Setter
    private float tntDay;

    @Column(name = "tni_doba")
    @Getter @Setter
    private float tniDay;

}
