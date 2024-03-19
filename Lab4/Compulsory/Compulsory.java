package Compulsory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Compulsory {
    public static void main(String[] args) {
        List<Person> persons = generateRandomPersons(20); // Generate 20 random persons

        LinkedList<Driver> drivers = persons.stream()
                .filter(p -> p instanceof Driver)
                .map(p -> (Driver) p)
                .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = persons.stream()
                .filter(p -> p instanceof Passenger)
                .map(p -> (Passenger) p)
                .collect(Collectors.toCollection(() -> new TreeSet<>(java.util.Comparator.comparing(Passenger::getName))));

        // Print Drivers
        System.out.println("Drivers sorted by age:");
        drivers.forEach(d -> System.out.println(d.getName() + ", " + d.getAge()));

        // Print Passengers
        System.out.println("\nPassengers sorted by name:");
        passengers.forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));
    }

    private static List<Person> generateRandomPersons(int numberOfPersons) {
        List<Person> persons = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfPersons; i++) {
            if (random.nextBoolean()) {
                persons.add(new Driver("Driver" + i, 18 + random.nextInt(50), "Destination" + random.nextInt(5)));
            } else {
                persons.add(new Passenger("Passenger" + i, 18 + random.nextInt(50), "Destination" + random.nextInt(5)));
            }
        }
        return persons;
    }
}
