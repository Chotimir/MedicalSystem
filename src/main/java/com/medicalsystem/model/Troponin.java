package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "troponiny")
public class Troponin {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_troponiny")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia", nullable = false)
    @Getter @Setter
    private Admission admission;

    @Column(name = "tnt", nullable = false)
    @Getter @Setter
    private float tnt;

    @Column(name = "tnl_ultra", nullable = false)
    @Getter @Setter
    private float tnlUltra;

    @Column(name = "tnl", nullable = false)
    @Getter @Setter
    private float tnl;

    @Column(name = "tnt_doba", nullable = false)
    @Getter @Setter
    private float tntDay;

    @Column(name = "tnl_doba", nullable = false)
    @Getter @Setter
    private float tnlDay;

}
