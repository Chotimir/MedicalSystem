package com.medicalsystem.domain;

import javax.persistence.*;

/**
 * @author Kamil Komenda
 */
@Entity
public class Comorbidities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "disease_description_id")
    private DiseaseDescription diseaseDescription;

    public Comorbidities(Patient patient, Disease disease, DiseaseDescription diseaseDescription) {
        this.patient = patient;
        this.disease = disease;
        this.diseaseDescription = diseaseDescription;
    }

    public Comorbidities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public DiseaseDescription getDiseaseDescription() {
        return diseaseDescription;
    }

    public void setDiseaseDescription(DiseaseDescription diseaseDescription) {
        this.diseaseDescription = diseaseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comorbidities that = (Comorbidities) o;

        if (getId() != that.getId()) return false;
        if (getPatient() != null ? !getPatient().equals(that.getPatient()) : that.getPatient() != null) return false;
        if (getDisease() != null ? !getDisease().equals(that.getDisease()) : that.getDisease() != null)
            return false;
        return getDiseaseDescription() != null ? getDiseaseDescription().equals(that.getDiseaseDescription()) : that.getDiseaseDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getPatient() != null ? getPatient().hashCode() : 0);
        result = 31 * result + (getDisease() != null ? getDisease().hashCode() : 0);
        result = 31 * result + (getDiseaseDescription() != null ? getDiseaseDescription().hashCode() : 0);
        return result;
    }
}
