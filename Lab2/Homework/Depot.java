package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Depot {
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();

    // Constructor, Getters, Setters, and toString
    public Depot(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Depot)) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
            vehicle.setDepot(this);
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}