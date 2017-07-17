package com.medicalsystem.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.medicalsystem.model.Examination;

import java.io.IOException;

public class ExaminationSerializer extends JsonSerializer<Examination> {

    @Override
    public void serialize(Examination examination, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("description", examination.getDescription().getName());
        jgen.writeNumberField("result", examination.getResult());
        jgen.writeEndObject();
    }
}
