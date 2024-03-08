package Compulsory;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!" + "\n");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        for (String language : languages) {
            System.out.println(language);
        }
        System.out.println("\n");

        int n = (int) (Math.random() * 1000000);
        int result = n * 3;
        result += 0b10101;
        result += 0xFF;
        result = result * 6;

        System.out.println(result + "\n");

        while (result >= 10) {
            result = sumOfDigits(result);
        }

        System.out.println("Final result: " + result + "\n");

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    private static int sumOfDigits(int number) {

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}