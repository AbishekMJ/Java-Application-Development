package fullStackdeveloper;
//Program to demonstrate the Words and sentence Using Strings concept
	import java.util.Scanner;

	public class WordsAndSentences {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the sentence");
	        String sentence = scanner.nextLine();

	        System.out.println("Enter the word");
	        String word = scanner.nextLine();

	        if (isWordPresent(sentence, word)) {
	            System.out.println(word + " is present in the sentence");
	        } else {
	            System.out.println(word + " is not present in the sentence");
	        }
	    }

	    public static boolean isWordPresent(String sentence, String word) {
	        // Split the sentence into words using whitespace as the delimiter
	        String[] words = sentence.split(" ");

	        // Iterate through the words to find a match
	        for (String s : words) {
	            // Check if the word is present in the sentence (case-sensitive)
	            if (s.equals(word)) {
	                return true;
	            }
	        }

	        // Word not found in the sentence
	        return false;
	    }
	}
