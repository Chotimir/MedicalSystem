package com.medicalsystem.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.medicalsystem.model.ExaminationDescription;

import java.io.IOException;

public class ExaminationDescriptionSerializer extends JsonSerializer<ExaminationDescription> {

    @Override
    public void serialize(ExaminationDescription examinationDescription, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(examinationDescription.getName());
    }
}
