package com.medicalsystem.domain;

import javax.persistence.*;

/**
 * @author Kamil Komenda
 */
@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_id")
    private int diseaseId;

    @Column(name = "disease_name", columnDefinition = "VARCHAR(50)")
    private int diseaseName;

    public Disease(int diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Disease() {
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public int getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(int diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        if (getDiseaseId() != disease.getDiseaseId()) return false;
        return getDiseaseName() == disease.getDiseaseName();
    }

    @Override
    public int hashCode() {
        int result = getDiseaseId();
        result = 31 * result + getDiseaseName();
        return result;
    }
}
