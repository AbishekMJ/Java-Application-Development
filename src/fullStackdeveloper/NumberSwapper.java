package fullStackdeveloper;

import java.util.Scanner;

public class NumberSwapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers");

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        System.out.println("Before swapping");
        System.out.println("first = " + first + ", second = " + second);

        // Swapping using XOR bitwise operator
        first = first ^ second;
        second = first ^ second;
        first = first ^ second;

        System.out.println("After swapping");
        System.out.println("first = " + first + ", second = " + second);

        scanner.close();
    }
}
