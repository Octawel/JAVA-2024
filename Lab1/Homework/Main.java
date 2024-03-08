package Homework ;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Lab1 <a> <b> <k>");
            return;
        }

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);

            if (a > b || k < 0 || k > 9) {
                System.out.println("Invalid input. Ensure a <= b and 0 <= k <= 9.");
                return;
            }

            long startTime = System.nanoTime();

            StringBuilder result = new StringBuilder();
            for (int i = a; i <= b; i++) {
                if (isKReducible(i, k)) {
                    result.append(i).append(" ");
                }
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("K-reductible numbers: " + result.toString());
            System.out.println("Running time: " + duration + " nanoseconds");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers for a, b, and k.");
        }
    }

    private static boolean isKReducible(int number, int k) {
        while (number > 9) {
            number = sumOfSquaresOfDigits(number);
        }
        return number == k;
    }

    private static int sumOfSquaresOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
}
