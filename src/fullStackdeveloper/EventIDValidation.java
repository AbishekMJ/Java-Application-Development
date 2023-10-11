package fullStackdeveloper;
// Program to Demonstrate Event ID Validation using Regular Expressions
import java.util.Scanner;

	public class EventIDValidation  {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter your name");
	        String name = scanner.nextLine();

	        System.out.println("Enter your ID");
	        String id = scanner.nextLine();

	        if (isValidConferenceId(id)) {
	            String seatNumber = id.substring(3, 6);
	            String time = id.substring(6, 8);
	            String timeZone = id.substring(8);

	            System.out.println("Hi " + name + " your seat number is " + seatNumber + " and the event starts at " + time + timeZone);
	        } else {
	            System.out.println(id + " is an Invalid ID");
	        }
	    }

	    public static boolean isValidConferenceId(String id) {
	        if (id.length() != 10) {
	            return false;
	        }

	        String company = id.substring(0, 3);
	        String seatNumber = id.substring(3, 6);
	        String time = id.substring(6, 8);
	        String timeZone = id.substring(8);

	        if (!company.equals("SPC") || !seatNumber.matches("\\d{3}") || !isValidTime(time) || (!timeZone.equals("AM") && !timeZone.equals("PM"))) {
	            return false;
	        }

	        return true;
	    }

	    public static boolean isValidTime(String time) {
	        try {
	            int hour = Integer.parseInt(time);
	            return hour > 0 && hour <= 12;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	}



