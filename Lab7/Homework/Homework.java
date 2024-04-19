package Homework;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        final int n = 10;
        final int numberOfPlayers = 4;
        final long timeLimit = 1000;
        Bag bag = new Bag(n);
        Object turnLock = new Object();

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player(i, bag, turnLock, numberOfPlayers, n));
        }

        TimeKeeper timeKeeper = new TimeKeeper(timeLimit, players, turnLock);
        timeKeeper.start();

        for (Player player : players) {
            player.start();
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                System.out.println("Game interrupted. Checking final results.");
                break;
            }
        }

        System.out.println("\nFinal Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + " - Longest Sequence Length: " + player.getLongestSequence());
        }

        Player winner = players.stream()
                .max((p1, p2) -> Integer.compare(p1.getLongestSequence(), p2.getLongestSequence()))
                .orElse(null);

        if (winner != null && players.stream().filter(p -> p.getLongestSequence() == winner.getLongestSequence()).count() == 1) {
            System.out.println("Winner is " + winner.getName() + " with a sequence of length " + winner.getLongestSequence());
        } else {
            System.out.println("It's a tie!");
        }
    }
}
