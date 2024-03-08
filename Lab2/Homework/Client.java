package Homework;

import java.util.Objects;

class Client {
    private String name;
    private String visitingTimeInterval;
    private ClientType type;

    // Constructor, Getters, Setters, and toString

    public Client(String name, String visitingTimeInterval, ClientType type) {
        this.name = name;
        this.visitingTimeInterval = visitingTimeInterval;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}