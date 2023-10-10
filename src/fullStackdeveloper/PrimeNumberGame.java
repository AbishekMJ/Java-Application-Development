package fullStackdeveloper;
//Demonstrate the Program of Prime number Game on Arrays


	import java.util.Scanner;

	class ArrayOperations {
	    private int[] array1;
	    private int[] array2;

	    public ArrayOperations() {
	        array1 = null;
	        array2 = null;
	    }

	    public void setArray1(int[] arr) {
	        array1 = arr;
	    }

	    public void setArray2(int[] arr) {
	        array2 = arr;
	    }

	    public int[] addArrays() {
	        if (array1 == null || array2 == null || array1.length != array2.length) {
	            return null;
	        }

	        int[] resultArray = new int[array1.length];
	        for (int i = 0; i < array1.length; i++) {
	            resultArray[i] = array1[i] + array2[i];
	        }

	        return resultArray;
	    }

	    public int sumOfLastDigits(int[] arr) {
	        int sum = 0;
	        for (int num : arr) {
	            if (num < 0) {
	                System.out.println(num + " is an invalid input");
	                System.exit(1);
	            }
	            sum += num % 10;
	        }
	        return sum;
	    }
	}

	public class  PrimeNumberGame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayOperations arrayOps = new ArrayOperations();

	        System.out.println("Enter the size of first array");
	        int size1 = scanner.nextInt();

	        if (size1 <= 0) {
	            System.out.println(size1 + " is an invalid array size");
	            return;
	        }

	        int[] arr1 = new int[size1];
	        System.out.println("Enter the array elements");
	        for (int i = 0; i < size1; i++) {
	            arr1[i] = scanner.nextInt();
	            if (arr1[i] < 0) {
	                System.out.println(arr1[i] + " is an invalid input");
	                return;
	            }
	        }

	        arrayOps.setArray1(arr1);

	        System.out.println("Enter the size of second array");
	        int size2 = scanner.nextInt();

	        if (size2 <= 0) {
	            System.out.println(size2 + " is an invalid array size");
	            return;
	        }

	        int[] arr2 = new int[size2];
	        System.out.println("Enter the array elements");
	        for (int i = 0; i < size2; i++) {
	            arr2[i] = scanner.nextInt();
	            if (arr2[i] < 0) {
	                System.out.println(arr2[i] + " is an invalid input");
	                return;
	            }
	        }

	        arrayOps.setArray2(arr2);

	        int[] resultArray = arrayOps.addArrays();
	        if (resultArray == null) {
	            System.out.println("Both array size is different");
	            return;
	        }

	        int sumOfLastDigits = arrayOps.sumOfLastDigits(resultArray);

	        System.out.println(sumOfLastDigits + " is " + (isPrime(sumOfLastDigits) ? "a prime number" : "not a prime number"));
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

