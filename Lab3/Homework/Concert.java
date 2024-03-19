package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours;
    private double entryFee;

    public Concert(String name, String description, Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours, double entryFee) {
        super(name, description);
        this.openingHours = openingHours;
        this.entryFee = entryFee;
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getOpeningHours() {
        return openingHours;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }
}