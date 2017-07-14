package com.medicalsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "troponiny")
public class Troponin extends IdComparableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_troponiny")
    @Getter @Setter
    @JsonIgnore
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia")
    @Getter @Setter
    @JsonBackReference
    @JsonIgnore
    private Admission admission;

    @Column(name = "tnt")
    @Getter @Setter
    private double tnt;

    @Column(name = "tni_ultra")
    @Getter @Setter
    private double tnlUltra;

    @Column(name = "tnl")
    @Getter @Setter
    private double tnl;

    @Column(name = "tnt_doba")
    @Getter @Setter
    private double tntAfter24h;

    @Column(name = "tni_doba")
    @Getter @Setter
    private double tnlAfter24h;

}
