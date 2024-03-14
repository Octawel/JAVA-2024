package Homework;

public class Truck extends Vehicle {
    private final int capacity;

    public Truck(String plateNumber, Depot depot, int capacity) {
        super(plateNumber, depot);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}