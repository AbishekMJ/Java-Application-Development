package fullStackdeveloper;

import java.util.Scanner;

	// Create a public interface BonusPoints with an abstract method calculateBonusPoints
import java.util.Scanner;

//Interface for calculating bonus points
interface BonusPoints {
 double calculateBonusPoints();
}

//Interface for calculating delivery charges
interface DoorDelivery {
 double deliveryCharge();
}

//CustomerDetails class implementing BonusPoints and DoorDelivery interfaces
class CustomerDetails implements BonusPoints, DoorDelivery {
 private String customerName;
 private String phoneNumber;
 private String streetName;
 private double billAmount;
 private int distance;

 // Constructor to initialize customer details
 public CustomerDetails(String customerName, String phoneNumber, String streetName, double billAmount, int distance) {
     this.customerName = customerName;
     this.phoneNumber = phoneNumber;
     this.streetName = streetName;
     this.billAmount = billAmount;
     this.distance = distance;
 }

 // Getter and Setter methods
 public String getCustomerName() {
     return customerName;
 }

 public String getPhoneNumber() {
     return phoneNumber;
 }

 public String getStreetName() {
     return streetName;
 }

 public double getBillAmount() {
     return billAmount;
 }

 public int getDistance() {
     return distance;
 }

 // Calculate bonus points based on bill amount
 public double calculateBonusPoints() {
     if (billAmount >= 250) {
         return billAmount / 10.0;
     } else {
         return 0.0;
     }
 }

 // Calculate delivery charges based on distance
 public double deliveryCharge() {
     if (distance >= 25) {
         return distance * 8.0;
     } else if (distance >= 15) {
         return distance * 5.0;
     } else {
         return distance * 2.0;
     }
 }
}

public class DepartmentalStore {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Input customer details
     System.out.println("Enter the customer name");
     String customerName = scanner.nextLine();

     System.out.println("Enter the phone number");
     String phoneNumber = scanner.nextLine();

     System.out.println("Enter the street name");
     String streetName = scanner.nextLine();

     System.out.println("Enter the bill amount");
     double billAmount = scanner.nextDouble();

     System.out.println("Enter the distance");
     int distance = scanner.nextInt();

     // Create a CustomerDetails object
     CustomerDetails customer = new CustomerDetails(customerName, phoneNumber, streetName, billAmount, distance);

     // Display customer details
     System.out.println("Customer name: " + customer.getCustomerName());
     System.out.println("Phone number: " + customer.getPhoneNumber());
     System.out.println("Street name: " + customer.getStreetName());

     // Calculate and display bonus points
     double bonusPoints = customer.calculateBonusPoints();
     System.out.println("Bonus points: " + bonusPoints);

     // Calculate and display delivery charges
     double deliveryCharge = customer.deliveryCharge();
     System.out.println("Delivery charge: " + deliveryCharge);

     scanner.close();
 }
}
