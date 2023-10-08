package fullStackdeveloper;

import java.util.Scanner;

public class AreaofShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sides");
        int sides = scanner.nextInt();

        double area = 0.0; // Initialize the area variable

        if (sides == 0) {
            System.out.println("Enter the radius");
            double radius = scanner.nextDouble();
            area = 3.14 * radius * radius;
            System.out.printf("Area of the Circle is %.2f%n", area);
        } else if (sides == 3) {
            System.out.println("Enter the base and height");
            double base = scanner.nextDouble();
            double height = scanner.nextDouble();
            area = (base * height) / 2;
            System.out.printf("Area of the Triangle is %.2f%n", area);
        } else if (sides == 4) {
            System.out.println("Enter the length");
            double length = scanner.nextDouble();
            
            System.out.println("Enter the breadth");
            double breadth = scanner.nextDouble();
            
            if (length == breadth) {
                area = length * length;
                System.out.printf("Area of the Square is %.2f%n", area);
            } else {
                area = length * breadth;
                System.out.printf("Area of the Rectangle is %.2f%n", area);
            }
        } else {
            System.out.println("Invalid side");
        }

        scanner.close();
    }
}
