package fullStackdeveloper;
// Program to demonstrate Profile Update using Regular Expressions
import java.util.Scanner;
public class ProfileUpdate {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter your name");
	        String name = scanner.nextLine();

	        System.out.println("Enter your PAN number");
	        String panNumber = scanner.nextLine();

	        if (!isValidPAN(panNumber)) {
	            System.out.println(panNumber + " is an invalid PAN number");
	            return;
	        }

	        System.out.println("Enter your E-mail ID");
	        String email = scanner.nextLine();

	        if (!isValidEmail(email)) {
	            System.out.println("Invalid E-mail ID");
	            return;
	        }

	        System.out.println("Profile of " + name + " updated successfully");
	    }

	    public static boolean isValidPAN(String panNumber) {
	        if (panNumber.length() != 10) {
	            return false;
	        }

	        String firstPart = panNumber.substring(0, 5);
	        String middlePart = panNumber.substring(5, 9);
	        String lastPart = panNumber.substring(9);

	        return firstPart.matches("[A-Z]+") && middlePart.matches("[0-9]+") && lastPart.matches("[A-Z]+");
	    }

	    public static boolean isValidEmail(String email) {
	        return email.matches("[a-z]{5,10}@digitec.com");
	    }
	}
