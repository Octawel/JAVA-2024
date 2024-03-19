package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Homework {
    public static void main(String[] args) {
        Map<LocalDate, Pair<LocalTime, LocalTime>> churchHours = new HashMap<>();
        churchHours.put(LocalDate.of(2024, 4, 10), new Pair<>(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        churchHours.put(LocalDate.of(2024, 4, 12), new Pair<>(LocalTime.of(9, 0), LocalTime.of(18, 0)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> concertHours = new HashMap<>();
        concertHours.put(LocalDate.of(2024, 4, 15), new Pair<>(LocalTime.of(19, 0), LocalTime.of(23, 0)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> statueHours = new HashMap<>();
        statueHours.put(LocalDate.of(2024, 4, 11), new Pair<>(LocalTime.of(10, 0), LocalTime.of(17, 0)));
        statueHours.put(LocalDate.of(2024, 4, 14), new Pair<>(LocalTime.of(10, 0), LocalTime.of(17, 0)));

        Church church = new Church("St. Peter's Basilica", "A Renaissance masterpiece in Vatican City", churchHours);
        Concert concert = new Concert("Live Rock Concert", "Annual rock music concert in the central park", concertHours, 50.0);
        Statue statue = new Statue("Liberty Statue", "A symbol of freedom and democracy", statueHours);

        Trip trip = new Trip("Rome", "April 2024");
        trip.addAttraction(church);
        trip.addAttraction(concert);
        trip.addAttraction(statue);

        System.out.println("Visitable but not Payable Attractions in " + trip.getCity() + ":");
        trip.displayVisitableNotPayable();

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addAttraction(LocalDate.of(2024, 4, 10), church);
        travelPlan.addAttraction(LocalDate.of(2024, 4, 11), statue);
        travelPlan.addAttraction(LocalDate.of(2024, 4, 12), church);
        travelPlan.addAttraction(LocalDate.of(2024, 4, 14), statue);
        travelPlan.addAttraction(LocalDate.of(2024, 4, 15), concert);

        System.out.println("\nDetailed Travel Plan for " + trip.getPeriod() + ":");
        travelPlan.printPlan();
    }
}
