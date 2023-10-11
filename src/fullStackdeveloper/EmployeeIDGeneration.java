package fullStackdeveloper;
// Program to Demonstrate Employee ID Generation using Strings 
import java.util.Scanner;

public class EmployeeIDGeneration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the training id");
        String trainingId = scanner.nextLine();

        String employeeId = generateEmployeeId(trainingId);
        if (employeeId != null) {
            System.out.println("Employee Id: " + employeeId);
        }
    }

    public static String generateEmployeeId(String trainingId) {
        if (trainingId.length() != 9) {
            System.out.println(trainingId + " is an invalid training id");
            return null;
        }

        String year = trainingId.substring(0, 4);
        String teamCode = trainingId.substring(4, 6);
        String rollNumber = trainingId.substring(6);

        if (!year.equals("2021")) {
            System.out.println(year + " is an invalid year");
            return null;
        }

        String team = getTeamCode(teamCode);
        if (team == null) {
            System.out.println(teamCode + " is an invalid team code");
            return null;
        }

        if (!isValidRollNumber(rollNumber)) {
            System.out.println(rollNumber + " is an invalid roll number");
            return null;
        }

        return "SIET" + team + rollNumber;
    }

    public static String getTeamCode(String code) {
        switch (code) {
            case "01":
                return "LP";
            case "02":
                return "TA";
            case "03":
                return "CT";
            case "04":
                return "PT";
            case "05":
                return "TT";
            default:
                return null;
        }
    }

    public static boolean isValidRollNumber(String rollNumber) {
        try {
            int roll = Integer.parseInt(rollNumber);
            return roll >= 1 && roll <= 999;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

