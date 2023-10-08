package fullStackdeveloper;

import java.util.Scanner;

public class MagicGooseEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the day");
        int day = scanner.nextInt();

        if (day <= 0 || day > 30) {
            System.out.println(day + " is an invalid day");
        } else {
            long result = calculateEggs(day);
            System.out.println("Number of eggs laid on day " + day + " is " + result);
        }

        scanner.close();
    }

    // Function to calculate the number of eggs using the Pell series
    public static long calculateEggs(int day) {
        if (day == 1 || day == 2) {
            return day;
        }

        long prev = 1, current = 2;
        for (int i = 3; i <= day; i++) {
            long next = 2 * current + prev;
            prev = current;
            current = next;
        }

        return current;
    }
}
