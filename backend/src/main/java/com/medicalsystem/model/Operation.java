package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "operacja")
public class Operation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacji")
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "tryb_zabiegu")
    @Getter @Setter
    private OperationMode operationMode;

    @ManyToOne
    @JoinColumn(name = "znieczulenie")
    @Getter @Setter
    private Anesthesia anesthesia;

    @ManyToOne
    @JoinColumn(name = "lek_znieczulajacy")
    @Getter @Setter
    private Anesthetic anesthetic;

    @Column(name = "czas_trwania")
    @Getter @Setter
    private int duration;

    @Column(name = "czas_klemacji_aorty")
    @Getter @Setter
    private int aortaClottingTime;

    @Column(name = "noradrenalina")
    @Getter @Setter
    private boolean noradrenaline;

    @Column(name = "adrenalina")
    @Getter @Setter
    private boolean adrenaline;

    @Column(name = "dopamina")
    @Getter @Setter
    private boolean dopamine;

    @Column(name = "dobutamina")
    @Getter @Setter
    private boolean dobutamine;

    @Column(name = "efedryna")
    @Getter @Setter
    private boolean ephedrine;

    @Column(name = "utracona_krew")
    @Getter @Setter
    private int bloodLost;

    @Column(name = "wydalony_mocz")
    @Getter @Setter
    private int urineExpelled;

    @Column(name = "przetoczony_kkcz")
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

    @ManyToMany
    @JoinTable(
            name = "powiklania_operacja",
            joinColumns = @JoinColumn(name = "id_operacji", referencedColumnName = "id_operacji"),
            inverseJoinColumns = @JoinColumn(name = "id_powiklania", referencedColumnName = "id_powiklania")
    )
    @Getter @Setter
    private List<Complication> complications;

}
