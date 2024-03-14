package Homework;
import java.util.Objects;

public abstract class Vehicle {
    private final String plateNumber;
    private final Depot depot;

    protected Vehicle(String plateNumber, Depot depot) {
        this.plateNumber = plateNumber;
        this.depot = depot;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Depot getDepot() {
        return depot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return plateNumber.equals(vehicle.plateNumber) && depot.equals(vehicle.depot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, depot);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "plateNumber='" + plateNumber + '\'' +
                ", depot=" + depot +
                '}';
    }
}