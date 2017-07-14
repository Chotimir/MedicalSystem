package com.medicalsystem.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplicationPropertyTest {

    @Autowired
    private ComplicationProperties complicationProperties;

    @Test
    public void test() {
        complicationProperties.getComplications().forEach(c -> System.out.println(c.getNumber()));
    }

}
