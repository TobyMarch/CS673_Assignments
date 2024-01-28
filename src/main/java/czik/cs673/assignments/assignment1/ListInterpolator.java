package czik.cs673.assignments.assignment1;

import java.util.Scanner;

public class ListInterpolator {
    static char OPEN_BRACKET = '[';
    static char CLOSE_BRACKET = ']';
    static String DELIMITER = ",";

    public static void run(String[] args) {
        System.out.println("--- List Interpolator ---");
        try (Scanner inputScanner = new Scanner(System.in)) {
            System.out.println("Please input two comma-separated lists of equal length");
            System.out.println("List #1:");
            String inputString1 = inputScanner.nextLine();
            System.out.println("List #2:");
            String inputString2 = inputScanner.nextLine();

            String[] inputArray1 = convert(inputString1);
            String[] inputArray2 = convert(inputString2);

            if (inputArray1.length == inputArray2.length) {
                StringBuilder builder = new StringBuilder();
                builder.append("[");

                for (int i = 0; i < inputArray1.length; i++) {
                    builder.append(String.format("%s,%s", inputArray1[i], inputArray2[i]));
                    if (i <= inputArray1.length - 2) {
                        builder.append(",");
                    }
                }
                builder.append("]");

                System.out.println(builder.toString());
            }
        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }
    }

    private static String[] convert(String inputString) {
        int startingIndex = OPEN_BRACKET == inputString.charAt(0) ? 1 : 0;
        int endingIndex = CLOSE_BRACKET == inputString.charAt(inputString.length() - 1) ? inputString.length() - 1
                : inputString.length();
        return inputString.substring(startingIndex, endingIndex).split(DELIMITER);
    }
}
