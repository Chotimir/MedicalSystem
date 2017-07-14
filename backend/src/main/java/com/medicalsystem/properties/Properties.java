package com.medicalsystem.properties;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@PropertySources({
        @PropertySource("classpath:excelColumns.properties"),
        @PropertySource("classpath:columnGroupTitles.properties")
})
public class Properties {

    private final Environment env;

    public String get(String key) {
        return env.getProperty(key);
    }

    public int getAsInt(String key) {
        return Integer.parseInt(this.get(key));
    }

}
