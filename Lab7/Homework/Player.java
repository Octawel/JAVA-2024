package Homework;

import java.util.ArrayList;
import java.util.List;


class Player extends Thread {
    private static int currentTurn = 1;
    public final int playerId;
    private final Bag bag;
    private final List<List<Token>> sequences = new ArrayList<>();
    private final Object turnLock;
    private final int totalPlayers;
    private final int maxTokenNumber;
    private int longestSequence = 0;

    public Player(int playerId, Bag bag, Object turnLock, int totalPlayers, int maxTokenNumber) {
        super("Player " + playerId);
        this.playerId = playerId;
        this.bag = bag;
        this.turnLock = turnLock;
        this.totalPlayers = totalPlayers;
        this.maxTokenNumber = maxTokenNumber;
    }

    private void tryFormSequence(Token newToken) {
        boolean added = false;
        for (List<Token> seq : sequences) {
            if (canAddToSequence(seq, newToken)) {
                seq.add(newToken);
                added = true;
                break;
            }
        }
        if (!added) {
            List<Token> newSeq = new ArrayList<>();
            newSeq.add(newToken);
            sequences.add(newSeq);
        }
        updateLongestSequence();
    }

    private boolean canAddToSequence(List<Token> sequence, Token newToken) {
        Token lastToken = sequence.get(sequence.size() - 1);
        return lastToken.getSecondNumber() == newToken.getFirstNumber() && !containsNumber(sequence, newToken.getSecondNumber());
    }

    private boolean containsNumber(List<Token> sequence, int number) {
        for (Token token : sequence) {
            if (token.getFirstNumber() == number || token.getSecondNumber() == number) {
                return true;
            }
        }
        return false;
    }

    private void updateLongestSequence() {
        for (List<Token> seq : sequences) {
            if (seq.size() > longestSequence) {
                longestSequence = seq.size();
                if (longestSequence == maxTokenNumber) {
                    interruptOthers();
                }
            }
        }
    }

    private void interruptOthers() {
        synchronized (turnLock) {
            for (int i = 1; i <= totalPlayers; i++) {
                if (i != playerId) {
                    Thread.currentThread().getThreadGroup().interrupt();
                }
            }
        }
    }

    public int getLongestSequence() {
        return longestSequence;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (turnLock) {
                try {
                    while (playerId != currentTurn && !isInterrupted()) {
                        turnLock.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted while waiting.");
                    return;
                }

                if (isInterrupted() || bag.isEmpty()) {
                    System.out.println(getName() + " finishing up.");
                    return;
                }

                Token token = bag.extractToken();
                System.out.println(getName() + " extracted: " + token);
                tryFormSequence(token);

                currentTurn = (currentTurn % totalPlayers) + 1;
                turnLock.notifyAll();
            }
        }
    }
}