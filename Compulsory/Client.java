package Compulsory;

class Client {
    private String name;
    private String visitingTimeInterval;
    private ClientType type;

    public Client(String name, String visitingTimeInterval, ClientType type) {
        this.name = name;
        this.visitingTimeInterval = visitingTimeInterval;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisitingTimeInterval() {
        return visitingTimeInterval;
    }

    public void setVisitingTimeInterval(String visitingTimeInterval) {
        this.visitingTimeInterval = visitingTimeInterval;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + '\'' + ", visitingTimeInterval='" + visitingTimeInterval + '\'' + ", type=" + type + '}';
    }
}

