package fullStackdeveloper;
// program to demonstrate Alphabetical Order using Strings
import java.util.Scanner;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sentence");
        String sentence = scanner.nextLine();

        String result = arrangeLettersInAlphabeticalOrder(sentence);
        System.out.println(result);
    }

    public static String arrangeLettersInAlphabeticalOrder(String sentence) {
        // Check if the sentence contains only alphabets and spaces
        if (!isValidInput(sentence)) {
            return sentence + " is an invalid input";
        }

        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Sort the letters in the word in alphabetical order
            String sortedWord = sortWordAlphabetically(word);
            result.append(sortedWord).append(" ");
        }

        return result.toString().trim(); // Remove trailing space
    }

    public static boolean isValidInput(String sentence) {
        return sentence.matches("^[a-z ]+$");
    }

    public static String sortWordAlphabetically(String word) {
        char[] chars = word.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}
