package com.medicalsystem.model;

import javax.persistence.*;

/**
 * @author Kamil Komenda
 */
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String name;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String surname;

    @Column(columnDefinition = "VARCHAR(1) NOT NULL")
    private String sex;

    @Column(columnDefinition = "INTEGER NOT NULL")
    private int age;

    public Patient(String name, String surname, String sex, int age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    public Patient() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (getPatientId() != patient.getPatientId()) return false;
        if (getAge() != patient.getAge()) return false;
        if (!getName().equals(patient.getName())) return false;
        return getSurname().equals(patient.getSurname());
    }

    @Override
    public int hashCode() {
        int result = getPatientId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getAge();
        return result;
    }
}
