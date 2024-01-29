package czik.cs673.assignments.assignment1;

import java.util.Scanner;

public class LeapYearValidator {
    public static void run(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            boolean isLeapYear = false;
            System.out.println("Enter a year:");
            Integer yearValue = inputScanner.nextInt();

            if (yearValue % 4 == 0) {
                if (yearValue % 100 == 0) {
                    if (yearValue % 400 == 0) {
                        isLeapYear = true;
                    }
                } else {
                    isLeapYear = true;
                }
            }
            System.out.println(String.format("%d is %s", yearValue, isLeapYear ? "a leap year" : "not a leap year"));
        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }
    }
}
