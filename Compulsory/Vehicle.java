package Compulsory;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String id;
    private Depot depot;
    private List<Client> clients;

    public Vehicle(String id, Depot depot) {
        this.id = id;
        this.depot = depot;
        this.clients = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() { return clients; }

    @Override
    public String toString() {
        return "Vehicle{id='" + id + '\'' + ", depot=" + depot + ", clients=" + clients + '}';
    }
}

