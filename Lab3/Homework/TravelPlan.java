package Homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class TravelPlan {
    private Map<LocalDate, List<Attraction>> plan = new LinkedHashMap<>();

    public void addAttraction(LocalDate date, Attraction attraction) {
        plan.computeIfAbsent(date, k -> new ArrayList<>()).add(attraction);
    }

    public void printPlan() {
        plan.forEach((date, attractions) -> {
            System.out.println("Date: " + date);
            attractions.forEach(attraction -> System.out.println(" - " + attraction.getName()));
        });
    }
}

