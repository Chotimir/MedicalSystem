package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ponowna_wizyta")
public class Revisit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ponownej_wizyty")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia")
    @Getter @Setter
    private Admission admission;

    @Column(name = "kontrolna_wizyta")
    @Getter @Setter
    private int controlVisit;

    @Column(name = "data_ponownego_przyjecia")
    @Getter @Setter
    private Date date;

    @OneToOne
    @JoinColumn(name = "przyczyna_ponownego_przyjecia")
    @Getter @Setter
    private RevisitCause cause;

}
