package Homework;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        CarpoolProblem carpoolProblem = new CarpoolProblem(30); // Generate 30 random persons

        Set<String> destinations = carpoolProblem.computeAllDestinations();
        System.out.println("All destinations: " + destinations);

        Map<String, List<Person>> destinationMap = carpoolProblem.mapDestinationsToPeople();
        destinationMap.forEach((destination, people) -> {
            System.out.println("Destination: " + destination + ", People: " + people.stream().map(Person::getName).collect(Collectors.joining(", ")));
        });

        carpoolProblem.solveCarpoolProblem();
    }
}

