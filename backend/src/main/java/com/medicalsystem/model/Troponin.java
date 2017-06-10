package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "troponiny")
public class Troponin {

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

    @Column(name = "tnl_ultra")
    @Getter @Setter
    private float tnlUltra;

    @Column(name = "tnl")
    @Getter @Setter
    private float tnl;

    @Column(name = "tnt_doba")
    @Getter @Setter
    private float tntDay;

    @Column(name = "tnl_doba")
    @Getter @Setter
    private float tnlDay;

}
