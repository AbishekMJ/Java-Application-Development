package fullStackdeveloper;
// In Arrays Program to Demonstrate sum of max
    import java.util.Arrays;
	import java.util.Scanner;
	public class sumofmax {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the array size");
	        int size = scanner.nextInt();

	        if (size <= 1) {
	            System.out.println(size + " is an invalid array size");
	            return;
	        }

	        if (size % 2 != 0) {
	            System.out.println(size + " is an odd number. Please enter an even number.");
	            return;
	        }

	        int[] numbers = new int[size];
	        System.out.println("Enter the numbers");

	        for (int i = 0; i < size; i++) {
	            numbers[i] = scanner.nextInt();
	        }

	        Arrays.sort(numbers);

	        int maxSum = 0;
	        for (int i = 0; i < size / 2; i++) {
	            int sum = numbers[i] + numbers[size - 1 - i];
	            maxSum = Math.max(maxSum, sum);
	        }

	        System.out.println("The maximum number is " + maxSum);
	    }
	}

