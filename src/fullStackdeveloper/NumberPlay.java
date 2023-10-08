package fullStackdeveloper;

import java.util.Scanner;

class NumberPuzzleSolver {
    public static int solvePuzzle(int number) {
        if (number < 10 || number > 99) {
            return -1; // Invalid number
        }

        if (number > 50) {
            int firstDigit = number / 10;
            int secondDigit = number % 10;
            return firstDigit - secondDigit;
        } else {
            int reversedNumber = (number % 10) * 10 + (number / 10);
            int firstDigit = reversedNumber / 10;
            int secondDigit = reversedNumber % 10;
            return firstDigit - secondDigit;
        }
    }
}

public class NumberPlay{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number");
        int inputNumber = scanner.nextInt();

        int result = NumberPuzzleSolver.solvePuzzle(inputNumber);

        if (result == -1) {
            System.out.println("Invalid number");
        } else {
            System.out.println("Explanation:");
            System.out.println(inputNumber + " is " + (inputNumber > 50 ? "greater" : "less or equal") + " than 50, so");
            System.out.println((inputNumber > 50 ? (inputNumber / 10 + " - " + inputNumber % 10) : (inputNumber % 10 + " - " + inputNumber / 10)) + " = " + result);
        }

        scanner.close();
    }
}
