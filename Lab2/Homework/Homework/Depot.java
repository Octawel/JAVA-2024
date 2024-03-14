package Homework;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Depot {
    private final String identifier;
    private final Set<Vehicle> vehicles = new HashSet<>();

    public Depot(String identifier) {
        this.identifier = identifier;
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    public Set<Vehicle> getVehicles() {
        return new HashSet<>(vehicles);
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(identifier, depot.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return "Depot{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}