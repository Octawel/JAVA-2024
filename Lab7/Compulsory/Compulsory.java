package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Compulsory {
    public static void main(String[] args) {
        int numberOfPlayers = 4;
        int n = 5;
        Bag bag = new Bag(n);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player " + i, bag));
        }

        for (Player player : players) {
            player.start();
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game over.");
    }
}

