package Homework;
import java.util.Objects;

public class Client {
    private final String name;
    private final ClientType type;
    private final int visitingTime;

    public Client(String name, ClientType type, int visitingTime) {
        this.name = name;
        this.type = type;
        this.visitingTime = visitingTime;
    }

    public String getName() {
        return name;
    }

    public ClientType getType() {
        return type;
    }

    public int getVisitingTime() {
        return visitingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return visitingTime == client.visitingTime && name.equals(client.name) && type == client.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, visitingTime);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", visitingTime=" + visitingTime +
                '}';
    }
}
