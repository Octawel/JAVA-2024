package Homework;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;

public class CarpoolProblem {
    private List<Person> people;
    private Faker faker;

    public CarpoolProblem(int numberOfPeople) {
        faker = new Faker();
        this.people = generateRandomPeople(numberOfPeople);
    }

    private List<Person> generateRandomPeople(int numberOfPeople) {
        List<Person> people = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfPeople; i++) {
            String name = faker.name().fullName();
            int age = 18 + random.nextInt(50);
            String destination = faker.country().capital();
            if (random.nextBoolean()) {
                people.add(new Driver(name, age, destination));
            } else {
                people.add(new Passenger(name, age, destination));
            }
        }
        return people;
    }

    public Set<String> computeAllDestinations() {
        return people.stream()
                .map(Person::getDestination)
                .collect(Collectors.toSet());
    }

    public Map<String, List<Person>> mapDestinationsToPeople() {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getDestination));
    }

    public void solveCarpoolProblem() {
        Map<String, List<Driver>> driversByDestination = people.stream()
                .filter(Driver.class::isInstance)
                .map(Driver.class::cast)
                .collect(Collectors.groupingBy(Driver::getDestination));

        Map<String, List<Passenger>> passengersByDestination = people.stream()
                .filter(Passenger.class::isInstance)
                .map(Passenger.class::cast)
                .collect(Collectors.groupingBy(Passenger::getDestination));

        List<String> matchedDestinations = new ArrayList<>();

        for (String destination : driversByDestination.keySet()) {
            if (passengersByDestination.containsKey(destination) && !driversByDestination.get(destination).isEmpty() && !passengersByDestination.get(destination).isEmpty()) {
                Driver driver = driversByDestination.get(destination).get(0);
                Passenger passenger = passengersByDestination.get(destination).get(0);
                System.out.println("Driver " + driver.getName() + " will take Passenger " + passenger.getName() + " to " + destination);
                matchedDestinations.add(destination);
            }
        }

        matchedDestinations.forEach(dest -> {
            driversByDestination.get(dest).removeIf(driver -> true);
            passengersByDestination.get(dest).removeIf(passenger -> true);
        });
    }
}

