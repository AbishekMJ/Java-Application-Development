package fullStackdeveloper;

import java.util.Scanner;

class OxygenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the room(in m)");
        double length = scanner.nextDouble();

        if (length <= 0) {
            System.out.println("Invalid length");
            scanner.close();
            return;
        }

        System.out.println("Enter the breadth of the room(in m)");
        double breadth = scanner.nextDouble();

        if (breadth <= 0) {
            System.out.println("Invalid breadth");
            scanner.close();
            return;
        }

        System.out.println("Enter the plant area of a single plant(in cm2)");
        double plantArea = scanner.nextDouble();

        if (plantArea <= 0) {
            System.out.println("Invalid plant area");
            scanner.close();
            return;
        }

        // Calculate the total number of plants
        double roomArea = (length * breadth);
        int totalPlants = (int) ((roomArea / (plantArea / (100 * 100))) / 10) * 10;

        // Calculate the total oxygen production
        double totalOxygenProduction = totalPlants * 0.9;

        System.out.println("Total number of plants is " + totalPlants);
        System.out.printf("Total oxygen production is %.2f litres\n", totalOxygenProduction);

        scanner.close();
    }
}
