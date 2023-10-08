package fullStackdeveloper;

// Program to demonstrate Volume calculator Constructor Overloading
import java.util.Scanner;

public class VolumeCalculator {
    // Calculate the volume of a cylinder
    public double calculateVolume(double radius, double height) {
        return 3.14 * radius * radius * height;
    }

    // Calculate the volume of a cuboid
    public double calculateVolume(int length, int breadth, int height) {
        return length * breadth * height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VolumeCalculator calculator = new VolumeCalculator();

        System.out.println("Enter the choice");
        System.out.println("1. Find Volume For Cylinder");
        System.out.println("2. Find Volume For Cuboid");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter the radius");
            double radius = scanner.nextDouble();
            System.out.println("Enter the height");
            double height = scanner.nextDouble();

            double cylinderVolume = calculator.calculateVolume(radius, height);
            System.out.printf("Volume of the Cylinder is %.2f\n", cylinderVolume);
        } else if (choice == 2) {
            System.out.println("Enter the length");
            int length = scanner.nextInt();
            System.out.println("Enter the breadth");
            int breadth = scanner.nextInt();
            System.out.println("Enter the height");
            int cuboidHeight = scanner.nextInt();

            double cuboidVolume = calculator.calculateVolume(length, breadth, cuboidHeight);
            System.out.printf("Volume of the Cuboid is %.2f\n", cuboidVolume);
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
