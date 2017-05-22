package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "operacja")
public class Operation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacji")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "tryb_zabiegu", nullable = false)
    @Getter @Setter
    private OperationMode operationMode;

    @ManyToOne
    @JoinColumn(name = "znieczulenie", nullable = false)
    @Getter @Setter
    private Anesthesia anesthesia;

    @ManyToOne
    @JoinColumn(name = "lek_znieczulajacy", nullable = false)
    @Getter @Setter
    private Anesthetic anesthetic;

    @Column(name = "czas_trwania", nullable = false)
    @Getter @Setter
    private int duration;

    @Column(name = "czas_klemacji_aorty", nullable = false)
    @Getter @Setter
    private int aortaClottingTime;

    @Column(name = "noradrenalina", nullable = false)
    @Getter @Setter
    private boolean noradrenaline;

    @Column(name = "adrenalina", nullable = false)
    @Getter @Setter
    private boolean adrenaline;

    @Column(name = "dopamina", nullable = false)
    @Getter @Setter
    private boolean dopamine;

    @Column(name = "dobutamina", nullable = false)
    @Getter @Setter
    private boolean dobutamine;

    @Column(name = "efedryna", nullable = false)
    @Getter @Setter
    private boolean ephedrine;

    @Column(name = "utracona_krew", nullable = false)
    @Getter @Setter
    private int bloodLost;

    @Column(name = "wydalony_mocz", nullable = false)
    @Getter @Setter
    private int urineExpelled;

    @Column(name = "przetoczony_kkcz", nullable = false)
    @Getter @Setter
    private int packedCellsTransfused;

    @Column(name = "czas_pobytu_icu")
    @Getter @Setter
    private int icuTime;

    @Column(name = "czas_pobytu_szpital")
    @Getter @Setter
    private int hospitalTime;

    @Column(name = "przedluzona_wentylacja")
    @Getter @Setter
    private boolean extendedVentilation;

    @Column(name = "dni_na_respiratorze")
    @Getter @Setter
    private int ventilatorDays;

}
