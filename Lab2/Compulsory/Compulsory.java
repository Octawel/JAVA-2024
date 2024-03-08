package Compulsory;

public class Compulsory {
    public static void main(String[] args) {
        Depot depot = new Depot("Depot 1");
        Vehicle vehicle = new Vehicle("Vehicle 1", depot);
        Client client1 = new Client("Client 1", "09:00-10:00", ClientType.REGULAR);
        Client client2 = new Client("Client 2", "11:00-12:00", ClientType.PREMIUM);

        vehicle.getClients().add(client1);
        vehicle.getClients().add(client2);

        System.out.println(depot);
        System.out.println(vehicle);
        System.out.println(client1);
        System.out.println(client2);
    }
}
