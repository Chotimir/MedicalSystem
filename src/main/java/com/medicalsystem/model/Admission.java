package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "przyjecie")
public class Admission {

    @Id @GeneratedValue @Column(name = "id_przyjecia") @Getter @Setter
    private int id;

    @JoinColumn(name = "id_pacjenta") @Getter @Setter
    private Patient patient;

    @JoinColumn(name = "id_operacji") @Getter @Setter
    private Operation operation;

    @Column(name = "data_przyjecia") @Getter @Setter
    private Date admissionDate;

    @Column(name = "data_zabiegu") @Getter @Setter
    private Date operationDate;

    @Column(name = "objawy_aa") @Getter @Setter
    private int aaSymptoms;

    @Column(name = "wymiary_aa") @Getter @Setter
    private int aaSize;

    @Column(name = "maks_wymiary_tetniaka") @Getter @Setter
    private int maxAneurysmSize;

    @Column(name = "badanie_obrazowe") @Getter @Setter
    private int imageExamination;

    @Column(name = "lokalizacja_tetniaka") @Getter @Setter
    private int aneurysmLocation;

    @Column(name = "palenie_tytoniu") @Getter @Setter
    private Smoking smoking;

    @Column(name = "skala_asa") @Getter @Setter
    private int asaScale;

    @Column(name = "lee_rcri") @Getter @Setter
    private int leeRcri;

    @Column(name = "p_possu") @Getter @Setter
    private int pPossu;

    @Column(name = "utrata_przytomnosci") @Getter @Setter
    private int faint;

    @Column(name = "reoperacja") @Getter @Setter
    private Reoperation reopration;

    @Column(name = "uwagi") @Getter @Setter
    private String comments;

}
