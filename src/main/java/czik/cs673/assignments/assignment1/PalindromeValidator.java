package czik.cs673.assignments.assignment1;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeValidator {

    public static void run(String[] args) {
        final String QUIT = "q";
        boolean isPalindrome = true;

        System.out.println("--- Palindrome Validator ---");

        try (Scanner inputScanner = new Scanner(System.in)) {
            System.out.println("Enter string to validate (or 'q' to quit):");
            String inputValue = inputScanner.nextLine().toLowerCase();
            while (!inputValue.equals(QUIT)) {
                isPalindrome = true;
                if (inputValue.length() > 0) {
                    Stack<Character> charStack = new Stack<>();
                    boolean inputHasEvenLength = (inputValue.length() % 2 == 0);
                    int pivotCharacterIndex = inputHasEvenLength ? (inputValue.length() / 2) - 1
                            : inputValue.length() / 2;

                    for (int i = 0; i < inputValue.length(); i++) {
                        Character currentCharacter = inputValue.charAt(i);
                        if (i < pivotCharacterIndex) {
                            charStack.push(currentCharacter);
                        } else if (i == pivotCharacterIndex && inputHasEvenLength) {
                            charStack.push(currentCharacter);
                        } else if (i > pivotCharacterIndex) {
                            if (!charStack.pop().equals(currentCharacter)) {
                                isPalindrome = false;
                                break;
                            }
                        }
                    }
                }
                System.out.println(
                        String.format("The string \'%s\' is %s", inputValue,
                                isPalindrome ? "a palindrome" : "not a palindrome"));

                System.out.println("Enter another string to validate (or 'q' to quit):");
                inputValue = inputScanner.nextLine().toLowerCase();
            }

        } catch (Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }
    }

}
