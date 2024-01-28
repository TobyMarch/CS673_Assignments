package czik.cs673.assignments.assignment1;

import java.math.BigInteger;
import java.util.Arrays;

public class FibbonacciCalculator {
    public static void run(String[] args) {
        BigInteger[] values = new BigInteger[100];
        try {
            for (int i = 0; i < values.length; i++) {
                if (i <= 1) {
                    values[i] = new BigInteger("1");
                } else {
                    BigInteger value1 = values[i - 2];
                    BigInteger value2 = values[i - 1];
                    values[i] = value1.add(value2);
                }
            }
            System.out.println(Arrays.toString(values));
        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }

    }
}
