package fullStackdeveloper;
// Demonstrate Program to Fishing competition using Strings
import java.util.Scanner;

public class Fishingcompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the details");
        String input = scanner.nextLine();
        String[] inputParts = input.split(":");

        
        if (inputParts.length != 5) {
            System.out.println("Invalid input format");
        } else {
            String name = inputParts[0];
            int age, bigFish, mediumFish, smallFish;

            try {
                age = Integer.parseInt(inputParts[1]);
                bigFish = Integer.parseInt(inputParts[2]);
                mediumFish = Integer.parseInt(inputParts[3]);
                smallFish = Integer.parseInt(inputParts[4]);

                if (age < 18) {
                    System.out.println(age + " is an invalid age");
                } else if (bigFish < 0 || mediumFish < 0 || smallFish < 0) {
                    System.out.println(bigFish + " is an invalid input");
                } else {
                    int totalPoints = calculatePoints(bigFish, mediumFish, smallFish);
                    System.out.println(name + " scored " + totalPoints + " points");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format");
            }
        }
    }

    public static int calculatePoints(int bigFish, int mediumFish, int smallFish) {
        int bigPoints = bigFish * 10;
        int mediumPoints = mediumFish * 6;
        int smallPoints = smallFish * 3;

        return bigPoints + mediumPoints + smallPoints;
    }
}

