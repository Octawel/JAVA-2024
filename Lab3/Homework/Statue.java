package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class Statue extends Attraction implements Visitable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours = new HashMap<>();

    public Statue(String name, String description) {
        super(name, description);
    }

    public void addOpeningHour(LocalDate date, LocalTime start, LocalTime end) {
        openingHours.put(date, new Pair<>(start, end));
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getOpeningHours() {
        return openingHours;
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        if (this.openingHours.containsKey(date)) {
            return this.openingHours.get(date).getLeft();
        }
        return null;
    }
}
