package fullStackdeveloper;

// Program to demonstrate  ArrayManipulation - Use try with multi catch

	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class ArrayManipulation{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            // Get the size of the array
	            System.out.println("Enter the size of an array");
	            int size = scanner.nextInt();

	            if (size <= 0) {
	                System.out.println("Array size should be positive");
	                return;
	            }

	            int[] array = new int[size];

	            // Get the array elements
	            System.out.println("Enter the array elements");
	            for (int i = 0; i < size; i++) {
	                array[i] = scanner.nextInt();
	            }

	            // Get the position of the element to be replicated
	            System.out.println("Enter the position of the element to be replicated");
	            int position = scanner.nextInt();

	            if (position < 0 || position >= size) {
	                System.out.println("Array index is out of range");
	            } else {
	                int replicatedElement = array[position];
	                System.out.print("The array elements are ");
	                for (int i = 0; i < size; i++) {
	                    System.out.print(array[i] + " ");
	                }
	                System.out.println(replicatedElement);
	            }

	        } catch (InputMismatchException e) {
	            System.out.println("Input was not in the correct format");
	        } catch (NegativeArraySizeException e) {
	            System.out.println("Array size should be positive");
	        }

	        scanner.close();
	    }
	}

