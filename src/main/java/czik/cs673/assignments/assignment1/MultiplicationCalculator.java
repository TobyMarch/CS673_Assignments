package czik.cs673.assignments.assignment1;

public class MultiplicationCalculator {

    static final int MAX_BASE = 12;
    static final int MAX_MULTIPLE = 12;

    public static void run(String[] args) {
        System.out.println("--- Multiplication Table ---");

        try {
            for (int i = 1; i <= MAX_MULTIPLE; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 1; j <= MAX_BASE; j++) {
                    String tableEntry = String.format("%d X %d = %d", j, i, Math.multiplyExact(j, i));
                    builder.append(String.format("%1$-15s", tableEntry));
                }
                System.out.println(builder.toString());
            }
        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }
    }

}
