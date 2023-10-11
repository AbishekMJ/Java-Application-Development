package fullStackdeveloper;

// Program to Demonstrate Find the Winner using Strings
import java.util.Scanner;
public class Findthewinner{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the number of teams");
	        int numberOfTeams = scanner.nextInt();

	        if (numberOfTeams < 2) {
	            System.out.println(numberOfTeams + " is an invalid input");
	            return;
	        }

	        scanner.nextLine(); // Consume the newline character

	        String winningTeam = null;
	        float shortestTime = Float.MAX_VALUE;

	            System.out.println("Enter the details");
	            for (int i = 1; i <= numberOfTeams; i++) {
	            String input = scanner.nextLine();
	            String[] inputParts = input.split(":");

	            if (inputParts.length != 5) {
	                System.out.println("Invalid input format");
	                return;
	            }

	            String teamName = inputParts[0];
	            float totalTeamTime = 0.0f;

	            for (int j = 1; j < inputParts.length; j++) {
	                float time = Float.parseFloat(inputParts[j]);

	                if (time < 1.0) {
	                    System.out.println("Invalid number");
	                    return;
	                }

	                totalTeamTime += time;
	            }

	            if (totalTeamTime < shortestTime) {
	                shortestTime = totalTeamTime;
	                winningTeam = teamName;
	            }
	        }

	        System.out.printf("%s team wins the race in %.2f minutes%n", winningTeam, shortestTime);
	    }
	}

