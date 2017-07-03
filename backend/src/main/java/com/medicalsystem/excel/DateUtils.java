package com.medicalsystem.excel;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""
            + "[M/d/y]"
            + "[d.M.y]"
            + "[d-M-y]"
    );

    public static Date fromString(String s) {
        return Date.valueOf(LocalDate.parse(s, formatter));
    }
}
