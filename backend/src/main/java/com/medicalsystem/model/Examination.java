package com.medicalsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicalsystem.json.deserializer.ExaminationDeserializer;
import com.medicalsystem.json.serializer.ExaminationSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "badania_przy_przyjeciu")
@JsonSerialize(using = ExaminationSerializer.class)
@JsonDeserialize(using = ExaminationDeserializer.class)
public class Examination extends IdComparableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_badania_przy_przyjeciu")
    @JsonIgnore
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_przyjecia")
    @Getter @Setter
    @JsonBackReference
    @JsonIgnore
    private Admission admission;

    @OneToOne
    @JoinColumn(name = "id_badania")
    @Getter @Setter
    private ExaminationDescription description;

    @Column(name = "wynik_badania")
    @Getter @Setter
    private double result;

}
