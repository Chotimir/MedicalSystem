package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tryb_zabiegu_s")
public class OperationMode {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tryb_zabiegu")
    @Getter @Setter
    private int operationMode;

    @Column(name = "nazwa_trybu_zabiegu", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String operationModeName;

}
