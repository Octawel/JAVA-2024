package Compulsory;

class Player extends Thread {
    private final String name;
    private final Bag bag;

    public Player(String name, Bag bag) {
        this.name = name;
        this.bag = bag;
    }

    @Override
    public void run() {
        while (true) {
            Token token = bag.extractToken();
            if (token == null) {
                break;
            }
            System.out.println(name + " extracted: " + token);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

