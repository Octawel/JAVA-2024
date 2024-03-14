package Homework;

public class Drone extends Vehicle {
    private final int maxFlightDuration;

    public Drone(String plateNumber, Depot depot, int maxFlightDuration) {
        super(plateNumber, depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }
}