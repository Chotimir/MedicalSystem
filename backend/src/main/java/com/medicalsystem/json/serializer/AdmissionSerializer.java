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
    private SelectFieldBuilder builder;

    public AdmissionSerializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void serialize(Admission admission, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        // TODO: temporary date fix
        jgen.writeStringField("admissionDate", admission.getAdmissionDate().toString().replaceAll("00", "20"));
        // TODO: temporary date fix
        jgen.writeStringField("operationDate", admission.getOperationDate().toString().replaceAll("00", "20"));
        // TODO: tworzę jsona na wzór SelectField z frontu z tylko jedną wybraną wartością, a może być ich wiele
        jgen.writeObjectField("operationType", builder.fromOperationType(admission.getOperationTypes().get(0)));
        jgen.writeObjectField("aorticAneurysmSymptoms", builder.fromAASymptoms(admission.getAaSymptoms()));
        jgen.writeNumberField("aorticAneurysmSize", admission.getAaSize());
        jgen.writeNumberField("maxIliacAneurysmSize", admission.getMaxAneurysmSize());

        jgen.writeObjectField("imagingExamination", builder.fromImageExamination(admission.getImageExamination()));
        jgen.writeObjectField("aneurysmLocation", "");
        jgen.writeObjectField("smoking", "");
        jgen.writeObjectField("asaScale", "");
        jgen.writeObjectField("leeRcri", "");
        jgen.writeObjectField("pPossum", "");
        jgen.writeObjectField("unconsciousness", "");
        jgen.writeObjectField("reoperation", "");

        jgen.writeStringField("comments", admission.getComments());

        jgen.writeEndObject();
    }
}
