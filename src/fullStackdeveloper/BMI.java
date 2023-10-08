package fullStackdeveloper;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter weight in kg");
        double weight = scanner.nextDouble();

        System.out.println("Enter height in cm");
        double height = scanner.nextDouble();

        // Convert height to meters
        height /= 100;

        // Calculate BMI
        double bmi = weight / (height * height);

        // Round BMI to 2 decimal places
        bmi = Math.round(bmi * 100.0) / 100.0;

        System.out.println("Your BMI is " + bmi);

        if (bmi >= 25) {
            System.out.println("You are overweight");
            double kgToReduce = bmi - 24.9; // The BMI threshold for being overweight is 25
            System.out.println("Reduce " + kgToReduce + " kg to be fit");
        } else if (bmi >= 18.5) {
            System.out.println("You are fit and healthy");
        } else {
            System.out.println("You are underweight");
            double kgToGain = 18.5 - bmi; // The BMI threshold for being underweight is 18.5
            System.out.println("Gain " + kgToGain + " kg to be fit");
        }

        scanner.close();
    }
}
