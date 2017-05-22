package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

public class Admission {

    private int id;

    private Patient patient;

    private Operation operation;

    private Date admissionDate;
    private Date operationDate;
    private int aaSymptoms;
    private int aaSize;

    private int maxAneurysmSize;
    private int imageExamination;

    private int aneurysmLocation;
    private Smoking smoking;
    private int asaScale;
    private int leeRcri;
    private int pPossu;

    private int faint;

    private Reoperation reopration;
    private String comments;

}
