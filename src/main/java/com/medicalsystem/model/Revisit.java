package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ponowna_wizyta")
public class Revisit {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ponownej_wizyty")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia", nullable = false)
    @Getter @Setter
    private Admission admission;

    @Column(name = "kontrolna_wizyta", nullable = false)
    @Getter @Setter
    private int controlVisit;

    @Column(name = "data_ponownego_przyjecia", nullable = false)
    @Getter @Setter
    private Date revisitDate;

    @OneToOne
    @JoinColumn(name = "przyczyna_ponownego_przyjecia")
    @Getter @Setter
    private RevisitCause cause;

}
