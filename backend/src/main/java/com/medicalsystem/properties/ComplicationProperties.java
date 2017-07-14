package com.medicalsystem.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:excelColumns.properties")
@ConfigurationProperties(prefix = "excel")
public class ComplicationProperties {

    @Getter @Setter
    private List<ComplicationPair> complications;

    public static class ComplicationPair {

        @Getter @Setter
        private String name;

        @Getter @Setter
        private String number;

    }

}
