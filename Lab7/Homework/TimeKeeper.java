package Homework;

import java.util.List;

class TimeKeeper extends Thread {
    private final long timeLimit;
    private final List<Player> players;
    private final Object turnLock;

    public TimeKeeper(long timeLimit, List<Player> players, Object turnLock) {
        super("TimeKeeper");
        this.timeLimit = timeLimit;
        this.players = players;
        this.turnLock = turnLock;
        setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeLimit);
        } catch (InterruptedException e) {
            System.out.println("TimeKeeper interrupted unexpectedly.");
            return;
        }
        System.out.println("Time's up! Interrupting all players.");
        synchronized (turnLock) {
            for (Player player : players) {
                player.interrupt();
            }
            turnLock.notifyAll();
        }
    }
}
