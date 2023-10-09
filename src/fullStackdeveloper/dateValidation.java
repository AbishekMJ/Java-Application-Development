package fullStackdeveloper;
//Program to demonstrate Date Validation-Use Simple Date Formate
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;

	public class dateValidation{

	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     System.out.println("Enter the date");
	     String userInput = scanner.nextLine();

	     if (isValidDate(userInput, "dd/MM/yyyy")) {
	         System.out.println(userInput + " is a valid date");
	     } else {
	         System.out.println(userInput + " is not a valid date");
	     }

	     scanner.close();
	 }

	 public static boolean isValidDate(String dateStr, String format) {
	     SimpleDateFormat sdf = new SimpleDateFormat(format);
	     sdf.setLenient(false);

	     try {
	         Date date = sdf.parse(dateStr);
	         return date != null;
	     } catch (ParseException e) {
	         return false;
	     }
	 }
	}
