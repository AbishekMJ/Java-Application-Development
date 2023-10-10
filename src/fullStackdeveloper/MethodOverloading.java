package fullStackdeveloper;
//Program to demonstrate Method Overloading-Logical Analysis
import java.util.Scanner;

public class MethodOverloading {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Enter value1");
		        float value1 = scanner.nextFloat();

		        System.out.println("Enter value2");
		        float value2 = scanner.nextFloat();

		        float areaSquare = calculateArea(value1);
		        float areaRectangle = calculateArea(value1, value2);

		        System.out.println("Area of square " + areaSquare);
		        System.out.println("Area of rectangle " + areaRectangle);

		        scanner.close();
		    }

		    public static float calculateArea(float side) {
		        return side * side;
		    }

		    public static float calculateArea(float length, float breadth) {
		        return length * breadth;
		    }
		}
