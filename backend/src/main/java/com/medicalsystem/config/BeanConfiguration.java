package com.medicalsystem.config;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DataFormatter formatter() {
        return new DataFormatter();
    }

}
