package com.medicalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "przyjecie")
public class Admission extends IdComparableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_przyjecia")
    @Getter @Setter
    private int id;

    @OneToOne
    @JoinColumn(name = "id_pacjenta")
    @Getter @Setter
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "id_operacji")
    @Getter @Setter
    private Operation operation;

    @Column(name = "data_przyjecia")
    @Getter @Setter
    private Date admissionDate;

    @Column(name = "data_zabiegu")
    @Getter @Setter
    private Date operationDate;

    @Column(name = "objawy_aa")
    @Getter @Setter
    private int aaSymptoms;

    @Column(name = "wymiary_aa")
    @Getter @Setter
    private int aaSize;

    @Column(name = "maks_wymiary_tetniaka")
    @Getter @Setter
    private int maxAneurysmSize;

    @Column(name = "badanie_obrazowe")
    @Getter @Setter
    private int imageExamination;

    @Column(name = "lokalizacja_tetniaka")
    @Getter @Setter
    private int aneurysmLocation;

    @ManyToOne
    @JoinColumn(name = "palenie_tytoniu")
    @Getter @Setter
    private Smoking smoking;

    @Column(name = "skala_asa")
    @Getter @Setter
    private int asaScale;

    @Column(name = "lee_rcri")
    @Getter @Setter
    private int leeRcri;

    @Column(name = "p_possum")
    @Getter @Setter
    private double pPossum;

    @Column(name = "utrata_przytomnosci")
    @Getter @Setter
    private int faint;

    @ManyToOne
    @JoinColumn(name = "reoperacja")
    @Getter @Setter
    private Reoperation reoperation;

    @Column(name = "uwagi", columnDefinition = "text")
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
