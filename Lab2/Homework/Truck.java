package Homework;

class Truck extends Vehicle {
    private int capacity;

    public Truck(String id, Depot depot, int capacity) {
        super(id, depot);
        this.capacity = capacity;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}