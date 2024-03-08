package Homework;

public class Homework {
    public static void main(String[] args) {
        Depot depot1 = new Depot("Depot 1");

        Truck truck1 = new Truck("Truck 1", depot1, 1000);
        Drone drone1 = new Drone("Drone 1", depot1, 30);

        depot1.addVehicle(truck1);
        depot1.addVehicle(drone1);

        Client client1 = new Client("Client 1", "09:00-10:00", ClientType.REGULAR);
        Client client2 = new Client("Client 2", "10:30-11:00", ClientType.PREMIUM);

        Problem problem = new Problem();
        problem.addDepot(depot1);
        problem.addClient(client1);
        problem.addClient(client2);

        System.out.println("Vehicles available:");
        for (Vehicle vehicle : problem.getVehicles()) {
            System.out.println(vehicle.getType() + " - " + vehicle.getId() + " from " + vehicle.getDepot().getName());
        }
    }
}

