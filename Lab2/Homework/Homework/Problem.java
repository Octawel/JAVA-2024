package Homework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    private final List<Depot> depots = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();

    public void addDepot(Depot depot) {
        if (!depots.contains(depot)) {
            depots.add(depot);
        }
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }
    public List<Vehicle> getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            allVehicles.addAll(depot.getVehicles());
        }
        return allVehicles;
    }

    public Map<Vehicle, List<Client>> allocateClients() {
        Map<Vehicle, List<Client>> allocation = new HashMap<>();
        List<Vehicle> vehicles = getVehicles();

        for (Vehicle vehicle : vehicles) {
            allocation.put(vehicle, new ArrayList<>());
        }

        for (Client client : clients) {
            for (Vehicle vehicle : vehicles) {
                allocation.get(vehicle).add(client);
                break;
            }
        }

        return allocation;
    }
}