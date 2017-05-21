package com.medicalsystem.model;

import javax.persistence.*;

/**
 * @author Kamil Komenda
 */
@Entity
public class DiseaseDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_description_id", columnDefinition = "INTEGER")
    private int diseaseDescriptionId;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @Column(name = "name_complication_description", columnDefinition = "VARCHAR(50)")
    private int complicationDescription;

    public DiseaseDescription(Disease disease, int complicationDescription) {
        this.disease = disease;
        this.complicationDescription = complicationDescription;
    }

    public DiseaseDescription() {
    }

    public int getDiseaseDescriptionId() {
        return diseaseDescriptionId;
    }

    public void setDiseaseDescriptionId(int diseaseDescriptionId) {
        this.diseaseDescriptionId = diseaseDescriptionId;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getComplicationDescription() {
        return complicationDescription;
    }

    public void setComplicationDescription(int complicationDescription) {
        this.complicationDescription = complicationDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiseaseDescription that = (DiseaseDescription) o;

        if (getDiseaseDescriptionId() != that.getDiseaseDescriptionId()) return false;
        if (getComplicationDescription() != that.getComplicationDescription()) return false;
        return getDisease() != null ? getDisease().equals(that.getDisease()) : that.getDisease() == null;
    }

    @Override
    public int hashCode() {
        int result = getDiseaseDescriptionId();
        result = 31 * result + (getDisease() != null ? getDisease().hashCode() : 0);
        result = 31 * result + getComplicationDescription();
        return result;
    }
}
