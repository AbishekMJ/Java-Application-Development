package fullStackdeveloper;
import java.util.Scanner;

public class SmallestNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers");

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int smallest = (num1 <= num2) ? ((num1 <= num3) ? num1 : num3) : ((num2 <= num3) ? num2 : num3);

        if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal");
        } else {
            System.out.println("The smallest number is " + smallest);
        }

        scanner.close();
    }
}

