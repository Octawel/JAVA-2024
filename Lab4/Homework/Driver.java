package Homework;

public class Driver extends Person {
    public Driver(String name, int age, String destination) {
        super(name, age, destination);
    }

    @Override
    public String toString() {
        return "Driver: " + super.toString();
    }
}

