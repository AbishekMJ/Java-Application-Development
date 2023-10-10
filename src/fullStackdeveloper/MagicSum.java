package fullStackdeveloper;
// Demonstrate the Program of Magic sum on Arrays Concept
import java.util.Scanner;
public class MagicSum {
public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the array size");
	        int arraySize = scanner.nextInt();

	        if (arraySize < 1 || arraySize > 5) {
	            System.out.println(arraySize + " is an invalid array size");
	            return;
	        }

	        int[] numbers = new int[arraySize];

	        System.out.println("Enter the numbers");
	        for (int i = 0; i < arraySize; i++) {
	            int num = scanner.nextInt();
	            if (num <= 0 || num >= 100) {
	                System.out.println(num + " is an invalid input");
	                return;
	            }
	            numbers[i] = num;
	        }

	        boolean found = false;

	        for (int i = 0; i < arraySize; i++) {
	            if (isPrime(numbers[i])) {
	                int sum = 0;
	                for (int j = i; j < arraySize; j++) {
	                    if (isPrime(numbers[j])) {
	                        sum += numbers[j];
	                        if (isPrime(sum)) {
	                            System.out.println("The sum of prime numbers is");
	                            for (int k = i; k <= j; k++) {
	                                System.out.println(numbers[k]);
	                            }
	                            found = true;
	                            break;
	                        }
	                    } else {
	                        break;
	                    }
	                }
	            }
	        }

	        if (!found) {
	            System.out.println("The " + arraySize + " numbers are not sum of prime numbers");
	        }
	    }

	    private static boolean isPrime(int num) {
	        if (num <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
