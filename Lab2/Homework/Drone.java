package Homework;

class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String id, Depot depot, int maxFlightDuration) {
        super(id, depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    @Override
    public String getType() {
        return "Drone";
    }
}