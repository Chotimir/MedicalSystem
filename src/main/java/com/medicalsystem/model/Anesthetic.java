package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lek_znieczulajacy_s")
public class Anesthetic {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lek_znieczulajace")
    @Getter @Setter
    private int id;

    @Column(name = "nazwa_leku_znieczulajacego", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String name;

}
