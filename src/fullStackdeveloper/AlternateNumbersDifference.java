package fullStackdeveloper;
// program to demonstrate Alternate Numbers Difference - Code Analysis
import java.util.Scanner;
import java.util.Arrays;
public class AlternateNumbersDifference {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Enter the size of the array");
		        int size = scanner.nextInt();

		        if (size < 3) {
		            System.out.println("Invalid array size");
		            return;
		        }

		        int[] array = new int[size];
		        System.out.println("Enter the inputs");

		        for (int i = 0; i < size; i++) {
		            array[i] = scanner.nextInt();
		        }

		        int maxDiff = 0;
		        int smallestElement = array[0];
		        int smallestIndex = 0;

		        for (int i = 0; i < size - 1; i++) {
		            int diff = Math.abs(array[i] - array[i + 1]);
		            if (diff > maxDiff) {
		                maxDiff = diff;
		                smallestElement = Math.min(array[i], array[i + 1]);
		                smallestIndex = i;
		            }
		        }

		        System.out.println(smallestIndex);
		    }
		}
