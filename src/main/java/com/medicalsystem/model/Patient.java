package com.medicalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private char sex;
    private int age;
    private List<Disease> diseases;

}
