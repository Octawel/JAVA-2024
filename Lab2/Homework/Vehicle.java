package Homework;

import java.util.Objects;

abstract class Vehicle {
    protected String id;
    protected Depot depot;

    // Constructor, Getters, Setters
    public Vehicle(String id, Depot depot) {
        this.id = id;
        this.depot = depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public String getId() {
        return id;
    }

    public Depot getDepot() {
        return depot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract String getType();
}