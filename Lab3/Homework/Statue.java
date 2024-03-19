package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

class Statue extends Attraction implements Visitable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours;

    public Statue(String name, String description, Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours) {
        super(name, description);
        this.openingHours = openingHours;
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getOpeningHours() {
        return openingHours;
    }

    public void addOpeningHour(LocalDate date, LocalTime start, LocalTime end) {
        openingHours.put(date, new Pair<>(start, end));
    }
}
