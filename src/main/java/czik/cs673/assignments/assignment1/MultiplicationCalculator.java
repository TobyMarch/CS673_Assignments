package czik.cs673.assignments.assignment1;

import java.util.Scanner;

public class MultiplicationCalculator {

    static final int MAX_MULTIPLE = 12;

    public static void run(String[] args) {
        System.out.println("--- Multiplication Table ---");

        try (Scanner inputScanner = new Scanner(System.in)) {
            System.out.println("Enter Base Value:");
            Integer baseValue = inputScanner.nextInt();

            System.out.println("Generating Multiplication Table:");
            for (int i = 1; i <= MAX_MULTIPLE; i++) {
                System.out.println(String.format("%d X %d = %d", baseValue, i, Math.multiplyExact(baseValue, i)));
            }
        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }
    }

}
