package org.sebsy.grasps.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParser {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public LocalDateTime parseReservationDate(String dateStr) {
        return LocalDateTime.parse(dateStr, DEFAULT_FORMATTER);
    }
}
