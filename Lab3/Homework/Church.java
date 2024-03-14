package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

class Church extends Attraction implements Visitable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours = new LinkedHashMap<>();

    public Church(String name, String description) {
        super(name, description);
    }

    public void addOpeningHour(LocalDate date, LocalTime start, LocalTime end) {
        openingHours.put(date, new Pair<>(start, end));
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getOpeningHours() {
        return openingHours;
    }
}
