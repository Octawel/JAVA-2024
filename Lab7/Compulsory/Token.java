package Compulsory;

public class Token {
    private final int firstNumber;
    private final int secondNumber;

    public Token(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public String toString() {
        return "(" + firstNumber + "," + secondNumber + ")";
    }
}

