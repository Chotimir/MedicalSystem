package com.medicalsystem.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.medicalsystem.model.Examination;
import com.medicalsystem.service.ExaminationDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

public class ExaminationDeserializer extends JsonDeserializer<Examination> {

    @Autowired
    private ExaminationDescriptionService examinationDescriptionService;

    public ExaminationDeserializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public Examination deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String description = node.get("description").asText();
        double result = node.get("result").asDouble();

        Examination examination = new Examination();

        examination.setDescription(examinationDescriptionService.getByName(description));
        examination.setResult(result);

        return examination;
    }
}
