package fullStackdeveloper;
//Program to demonstrate Calculate Expiry Date Using-Use Calender
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalculateExpiryDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Manufacturing Date");
        String manufacturingDateStr = scanner.nextLine();

        // Validate and parse the manufacturing date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Disallow lenient parsing
        Date manufacturingDate;
        try {
            manufacturingDate = sdf.parse(manufacturingDateStr);
        } catch (ParseException e) {
            System.out.println(manufacturingDateStr + " is not a valid date");
            return;
        }

        System.out.println("Enter the Month");
        int monthsOfValidity = scanner.nextInt();

        // Calculate the expiry date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(manufacturingDate);
        calendar.add(Calendar.MONTH, monthsOfValidity);
        Date expiryDate = calendar.getTime();

        // Format and display the result
        String expiryDateStr = sdf.format(expiryDate);
        System.out.println(expiryDateStr + " is the expiry date");

        scanner.close();
    }
}
