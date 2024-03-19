package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

class Church extends Attraction implements Visitable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours;

    public Church(String name, String description, Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours) {
        super(name, description);
        this.openingHours = openingHours;
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getOpeningHours() {
        return openingHours;
    }
}
