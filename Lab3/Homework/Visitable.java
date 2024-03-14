package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

interface Visitable {
    Map<LocalDate, Pair<LocalTime, LocalTime>> getOpeningHours();
    default LocalTime getOpeningHour(LocalDate date) {
        Pair<LocalTime, LocalTime> hours = getOpeningHours().get(date);
        return hours != null ? hours.getLeft() : null;
    }
}

