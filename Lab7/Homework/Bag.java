package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Bag {
    private final List<Token> tokens = Collections.synchronizedList(new ArrayList<>());

    public Bag(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tokens.add(new Token(i, j));
                }
            }
        }
        Collections.shuffle(tokens);
    }

    public synchronized Token extractToken() {
        if (!tokens.isEmpty()) {
            return tokens.remove(0);
        }
        return null;
    }

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }
}