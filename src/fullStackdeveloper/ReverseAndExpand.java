package fullStackdeveloper;
import java.util.Scanner;
public class ReverseAndExpand {
     public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the number");
	        int number = scanner.nextInt();

	        // Check if the number is a 4-digit number
	        if (number >= 1000 && number <= 9999) {
	            int reversedNumber = 0;
	            int originalNumber = number;
	            int expandedSum = 0;
	            int placeValue = 1;

	            // Reverse the number and expand it
	            while (number > 0) {
	                int digit = number % 10;
	                reversedNumber = reversedNumber * 10 + digit;
	                expandedSum += digit * placeValue;
	                number /= 10;
	                placeValue *= 10;
	            }

	            System.out.println("Reversed number is " + reversedNumber);
	            System.out.println(expandedSum);
	        } else {
	            System.out.println(number + " is an invalid number");
	        }

	        scanner.close();
	    }
	}
