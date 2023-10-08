package fullStackdeveloper;

	import java.util.Scanner;

	public class NumberNamesConverter {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the number");
	        String input = scanner.nextLine().trim(); // Read the input as a string and remove leading/trailing whitespace

	        // Define an array to store the number names
	        String[] numberNames = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	        // Iterate through the characters in the input string and print the corresponding number names
	        for (int i = 0; i < input.length(); i++) {
	            char digit = input.charAt(i);
	            int digitValue = Character.getNumericValue(digit);

	            // Check if the digit is a valid number (0-9)
	            if (digitValue >= 0 && digitValue <= 9) {
	                System.out.print(numberNames[digitValue] + " ");
	            } else {
	                System.out.println("Invalid input: " + digit);
	                break;
	            }
	        }

	        scanner.close();
	    }
	}
