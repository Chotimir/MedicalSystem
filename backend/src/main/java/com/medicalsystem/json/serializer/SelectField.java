package com.medicalsystem.json.serializer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SelectField {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private List<String> values;

    @Getter @Setter
    private String selected;

}
