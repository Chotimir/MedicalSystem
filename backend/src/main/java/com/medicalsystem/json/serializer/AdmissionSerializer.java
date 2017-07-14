package com.medicalsystem.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.medicalsystem.json.SelectFieldBuilder;
import com.medicalsystem.model.Admission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

public class AdmissionSerializer extends JsonSerializer<Admission> {

    @Autowired
    private SelectFieldBuilder selectFieldBuilder;

    public AdmissionSerializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void serialize(Admission admission, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("admissionDate", admission.getAdmissionDate().toString());
        jsonGenerator.writeStringField("operationDate", admission.getOperationDate().toString());
        // TODO: tworzę jsona na wzór SelectField z frontu z tylko jedną wybraną wartością, a może być ich wiele
        jsonGenerator.writeObjectField("operationType", selectFieldBuilder.build(admission.getOperationTypes().get(0)));
        // TODO: aa symptoms
        //
        jsonGenerator.writeNumberField("aorticAneurysmSize", admission.getAaSize());
        jsonGenerator.writeNumberField("maxIliacAneurysmSize", admission.getAaSize());

        jsonGenerator.writeEndObject();
    }
}
