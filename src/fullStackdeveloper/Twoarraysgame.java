package fullStackdeveloper;
// Demonstrate the Program of Two Arrays Game in the Concept of Arrays

import java.util.Arrays;
	import java.util.Scanner;
	import java.util.Scanner;

	class ArrayOperation {
	    public static int[] performArrayOperation(int[] array1, int[] array2) {
	        int size = Math.min(array1.length, array2.length);
	        int[] resultArray = new int[size];

	        for (int i = 0; i < size; i++) {
	            if (i % 2 == 0) {
	                resultArray[i] = array1[i] + array2[i];
	            } else {
	                resultArray[i] = array1[i] - array2[i];
	            }
	        }

	        return resultArray;
	    }
	}

	public class Twoarraysgame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the size for the first array");
	        int size1 = scanner.nextInt();
	        if (size1 <= 0) {
	            System.out.println(size1 + " is an invalid array size");
	            return;
	        }

	        int[] array1 = new int[size1];

	        System.out.println("Enter the elements for the first array");
	        for (int i = 0; i < size1; i++) {
	            array1[i] = scanner.nextInt();
	        }

	        System.out.println("Enter the size for the second array");
	        int size2 = scanner.nextInt();
	        if (size2 <= 0) {
	            System.out.println(size2 + " is an invalid array size");
	            return;
	        }

	        int[] array2 = new int[size2];

	        System.out.println("Enter the elements for the second array");
	        for (int i = 0; i < size2; i++) {
	            array2[i] = scanner.nextInt();
	        }

	        if (size1 != size2) {
	            System.out.println("Both array sizes are not the same");
	        } else {
	            int[] resultArray = ArrayOperation.performArrayOperation(array1, array2);

	            System.out.println("The elements of the third array");
	            for (int i = 0; i < resultArray.length; i++) {
	                System.out.println(resultArray[i]);
	            }
	        }
	    }
	}
