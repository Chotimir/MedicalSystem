package com.medicalsystem.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");

    public static Date fromExcelString(String s) {
        return Date.valueOf(LocalDate.parse(s, formatter));
    }

}
