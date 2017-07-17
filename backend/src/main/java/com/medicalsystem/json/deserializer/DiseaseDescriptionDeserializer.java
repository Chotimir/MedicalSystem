package com.medicalsystem.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.medicalsystem.model.Disease;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.service.DiseaseDescriptionService;
import com.medicalsystem.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

public class DiseaseDescriptionDeserializer extends JsonDeserializer<DiseaseDescription> {

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private DiseaseDescriptionService diseaseDescriptionService;

    public DiseaseDescriptionDeserializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public DiseaseDescription deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        String name = node.get("name").asText();

        Disease disease = diseaseService.getByName(name);

        return null;
    }
}
