package fullStackdeveloper;
// Program to Demonstrate Complete the Caption on Strings

import java.util.Scanner;

public class CompletetheCaption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string");
        String firstString = scanner.nextLine();

        System.out.println("Enter the second string");
        String secondString = scanner.nextLine();

        String result = correctMisspelledWord(firstString, secondString);
        System.out.println(result);
    }

    public static String correctMisspelledWord(String firstString, String secondString) {
        // Check if the lengths of both strings match
        if (firstString.length() != secondString.length()) {
            return "Length of the strings " + firstString + " and " + secondString + " does not match";
        }

        // Flag to check if invalid symbols are found
        boolean invalidSymbolsFound = false;

        // Replace '!' with the corresponding character from the second string
        StringBuilder correctedString = new StringBuilder();
        for (int i = 0; i < firstString.length(); i++) {
            char char1 = firstString.charAt(i);
            char char2 = secondString.charAt(i);

            if (char1 == '!' && isAlphabetOrExclamation(char2)) {
                correctedString.append(char2);
            } else if (isAlphabetOrExclamation(char1) && isAlphabetOrExclamation(char2)) {
                correctedString.append(char1);
            } else {
                invalidSymbolsFound = true;
                break;
            }
        }

        if (invalidSymbolsFound) {
            return firstString + " and " + secondString + " contains invalid symbols";
        }

        return correctedString.toString();
    }

    public static boolean isAlphabetOrExclamation(char c) {
        return Character.isLetter(c) || c == '!';
    }
}
