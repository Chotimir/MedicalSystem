package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "przyjecie")
public class Admission {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_przyjecia")
    @Getter @Setter
    private int id;

    @OneToOne
    @JoinColumn(name = "id_pacjenta", nullable = false)
    @Getter @Setter
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "id_operacji", nullable = false)
    @Getter @Setter
    private Operation operation;

    @Column(name = "data_przyjecia", nullable = false)
    @Getter @Setter
    private Date admissionDate;

    @Column(name = "data_zabiegu", nullable = false)
    @Getter @Setter
    private Date operationDate;

    @Column(name = "objawy_aa", nullable = false)
    @Getter @Setter
    private int aaSymptoms;

    @Column(name = "wymiary_aa", nullable = false)
    @Getter @Setter
    private int aaSize;

    @Column(name = "maks_wymiary_tetniaka", nullable = false)
    @Getter @Setter
    private int maxAneurysmSize;

    @Column(name = "badanie_obrazowe", nullable = false)
    @Getter @Setter
    private int imageExamination;

    @Column(name = "lokalizacja_tetniaka", nullable = false)
    @Getter @Setter
    private int aneurysmLocation;

    @ManyToOne
    @JoinColumn(name = "palenie_tytoniu", nullable = false)
    @Getter @Setter
    private Smoking smoking;

    @Column(name = "skala_asa", nullable = false)
    @Getter @Setter
    private int asaScale;

    @Column(name = "lee_rcri", nullable = false)
    @Getter @Setter
    private int leeRcri;

    @Column(name = "p_possum", nullable = false)
    @Getter @Setter
    private int pPossum;

    @Column(name = "utrata_przytomnosci", nullable = false)
    @Getter @Setter
    private int faint;

    @ManyToOne
    @JoinColumn(name = "reoperacja", nullable = false)
    @Getter @Setter
    private Reoperation reopration;

    @Column(name = "uwagi", columnDefinition = "text", nullable = false)
    @Getter @Setter
    private String comments;

    @OneToMany(mappedBy = "admission")
    @Getter @Setter
    private List<Examination> examinations;

    @OneToMany(mappedBy = "admission")
    @Getter @Setter
    private List<Revisit> revisits;

    @OneToMany(mappedBy = "admission")
    @Getter @Setter
    private List<Troponin> troponins;

    @ManyToMany
    @JoinTable(
            name = "leki_stosowane_przed_zabiegiem",
            joinColumns = @JoinColumn(name = "id_przyjecia", referencedColumnName = "id_przyjecia"),
            inverseJoinColumns = @JoinColumn(name = "id_leku", referencedColumnName = "id_leku")
    )
    @Getter @Setter
    private List<Medicament> medicaments;

    @ManyToMany
    @JoinTable(
            name = "rodzaj_zabiegu",
            joinColumns = @JoinColumn(name = "id_przyjecia", referencedColumnName = "id_przyjecia"),
            inverseJoinColumns = @JoinColumn(name = "rodzaj_zabiegu", referencedColumnName = "id_rodzaju_zabiegu")
    )
    @Getter @Setter
    private List<OperationType> operationTypes;

}