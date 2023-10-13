package fullStackdeveloper;
// Program to Demonstrate the School Team - HashSet
import java.util.HashSet;
import java.util.Scanner;

public class SchoolTeam {
    private HashSet<String> studSet = new HashSet<>();

    public void addName(String details) {
        String[] parts = details.split(":");
        if (parts.length == 2) {
            String name = parts[1].trim();
            studSet.add(name);
        }
    }

    public HashSet<String> formTeam() {
        HashSet<String> teams = new HashSet<>();
        for (String name : studSet) {
            String house;
            char firstLetter = name.charAt(0);

            if (firstLetter >= 'A' && firstLetter <= 'H') {
                house = "RED";
            } else if (firstLetter >= 'I' && firstLetter <= 'P') {
                house = "BLUE";
            } else {
                house = "GREEN";
            }

            teams.add(name + ":" + house);
        }
        return teams;
    }

    public HashSet<String> getStudSet() {
        return studSet;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolTeam formation = new SchoolTeam();

        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (numStudents <= 0) {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("Enter the details: ");
        for (int i = 0; i < numStudents; i++) {
            String details = scanner.nextLine();
            formation.addName(details);
        }

        HashSet<String> teams = formation.formTeam();
        for (String team : teams) {
            System.out.println(team);
        }
    }
}
