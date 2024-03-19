package Compulsory;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Compulsory {
    public static void main(String[] args) {
        List<Person> persons = generateRandomPersons(20);
        LinkedList<Driver> drivers = persons.stream()
                .filter(p -> p instanceof Driver)
                .map(p -> (Driver) p)
                .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = persons.stream()
                .filter(p -> p instanceof Passenger)
                .map(p -> (Passenger) p)
                .collect(Collectors.toCollection(() -> new TreeSet<>(java.util.Comparator.comparing(Passenger::getName))));

        System.out.println("Drivers sorted by age:");
        drivers.forEach(d -> System.out.println(d.getName() + ", " + d.getAge()));

        System.out.println("\nPassengers sorted by name:");
        passengers.forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));
    }

    private static List<Person> generateRandomPersons(int numberOfPersons) {
        List<Person> persons = new LinkedList<>();
        Set<String> usedNames = new HashSet<>();
        Faker faker = new Faker();
        Random random = new Random();

        while (persons.size() < numberOfPersons) {
            String name = faker.name().fullName();
            if (!usedNames.contains(name)) {
                usedNames.add(name);
                int age = 18 + random.nextInt(50);
                String destination = "Destination" + random.nextInt(5);
                if (random.nextBoolean()) {
                    persons.add(new Driver(name, age, destination));
                } else {
                    persons.add(new Passenger(name, age, destination));
                }
            }
        }
        return persons;
    }
}
