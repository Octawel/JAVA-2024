package Homework;

import java.util.ArrayList;
import java.util.List;

class Problem {
    private List<Depot> depots = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

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
}

