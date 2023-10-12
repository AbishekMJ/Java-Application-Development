package fullStackdeveloper;
import java.util.Scanner;
// Program to Demonstrate Password Validation using Regular Expression
public class  PasswordValidator {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Generate your password");
	        String password = scanner.nextLine();

	        if (isValidPassword(password)) {
	            int lowercaseCount = countLowercaseLetters(password);
	            int uppercaseCount = countUppercaseLetters(password);
	            int specialCharacterCount = countSpecialCharacters(password);
	            int digitCount = countDigits(password);

	            System.out.println("The generated password " + password + " is valid and has " + lowercaseCount + " lowercase alphabet " + uppercaseCount + " uppercase alphabet " + specialCharacterCount + " special character " + digitCount + " digit");
	        } else {
	            System.out.println(password + " is an invalid password");
	        }
	    }

	    public static boolean isValidPassword(String password) {
	        if (password.length() < 6 || password.length() > 12) {
	            return false;
	        }

	        boolean hasLowercase = false;
	        boolean hasUppercase = false;
	        boolean hasSpecialCharacter = false;

	        for (char ch : password.toCharArray()) {
	            if (Character.isLowerCase(ch)) {
	                hasLowercase = true;
	            } else if (Character.isUpperCase(ch)) {
	                hasUppercase = true;
	            } else if ("@$*#".contains(String.valueOf(ch))) {
	                hasSpecialCharacter = true;
	            }
	        }

	        return hasLowercase && hasUppercase && hasSpecialCharacter;
	    }

	    public static int countLowercaseLetters(String password) {
	        int count = 0;
	        for (char ch : password.toCharArray()) {
	            if (Character.isLowerCase(ch)) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public static int countUppercaseLetters(String password) {
	        int count = 0;
	        for (char ch : password.toCharArray()) {
	            if (Character.isUpperCase(ch)) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public static int countSpecialCharacters(String password) {
	        int count = 0;
	        for (char ch : password.toCharArray()) {
	            if ("@$*#".contains(String.valueOf(ch))) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public static int countDigits(String password) {
	        int count = 0;
	        for (char ch : password.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                count++;
	            }
	        }
	        return count;
	    }
	}

