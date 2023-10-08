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

            // Reverse the number
            while (number > 0) {
                int digit = number % 10;
                reversedNumber = reversedNumber * 10 + digit;
                number /= 10;
            }

            System.out.println("Reversed number is " + reversedNumber);

            // Expand and print the number
            int placeValue = 1000;
            while (placeValue >= 1) {
                int digit = originalNumber / placeValue;
                System.out.print(digit * placeValue);
                originalNumber %= placeValue;
                placeValue /= 10;
                if (placeValue >= 1) {
                    System.out.print("+");
                }
            }
            System.out.println();
        } else {
            System.out.println(number + " is an invalid number");
        }

        scanner.close();
    }
}
