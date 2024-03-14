package Homework;

import java.util.List;
import java.util.Map;

public class Homework {
    public static void main(String[] args) {
        Depot depot1 = new Depot("Depot1");
        Depot depot2 = new Depot("Depot2");

        Vehicle truck1 = new Truck("Truck1", depot1, 1000);
        Vehicle drone1 = new Drone("Drone1", depot2, 30);
        depot1.addVehicle(truck1);
        depot2.addVehicle(drone1);

        Client client1 = new Client("Client1", ClientType.REGULAR, 15);
        Client client2 = new Client("Client2", ClientType.PREMIUM, 10);
        Client client3 = new Client("Client3", ClientType.REGULAR, 20);

        Problem problem = new Problem();
        problem.addDepot(depot1);
        problem.addDepot(depot2);
        problem.addClient(client1);
        problem.addClient(client2);
        problem.addClient(client3);

        Map<Vehicle, List<Client>> allocation = problem.allocateClients();

        for (Map.Entry<Vehicle, List<Client>> entry : allocation.entrySet()) {
            System.out.println("Vehicle: " + entry.getKey().getPlateNumber() + " from Depot: " + entry.getKey().getDepot().getIdentifier());
            for (Client client : entry.getValue()) {
                System.out.println("\tAllocated Client: " + client.getName() + ", Type: " + client.getType() + ", Visiting Time: " + client.getVisitingTime());
            }
        }
    }
}


