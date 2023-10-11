package fullStackdeveloper;
//program to Demonstrate ResortBooking Strings

	import java.util.Scanner;

	class Customer {
	    private String name;
	    private int numAdults;
	    private int numChildren;
	    private int numDays;

	    public Customer(String name, int numAdults, int numChildren, int numDays) {
	        this.name = name;
	        this.numAdults = numAdults;
	        this.numChildren = numChildren;
	        this.numDays = numDays;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getNumAdults() {
	        return numAdults;
	    }

	    public int getNumChildren() {
	        return numChildren;
	    }

	    public int getNumDays() {
	        return numDays;
	    }

	    public int calculateTotalCost() {
	        if (numAdults < 0) {
	            return -1;
	        }
	        if (numChildren < 0) {
	            return -2;
	        }
	        if (numDays <= 0) {
	            return -3;
	        }

	        int adultPrice = 1000;
	        int childPrice = 650;

	        int totalCost = (numAdults * adultPrice + numChildren * childPrice) * numDays;
	        return totalCost;
	    }
	}

	public class ResortBooking { 
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the customer details");
	        String input = scanner.nextLine();
	        String[] inputParts = input.split(":");

	        
	        if (inputParts.length != 4) {
	            System.out.println("Invalid input format");
	        } else {
	            String name = inputParts[0];
	            int numAdults, numChildren, numDays;

	            try {
	                numAdults = Integer.parseInt(inputParts[1]);
	                numChildren = Integer.parseInt(inputParts[2]);
	                numDays = Integer.parseInt(inputParts[3]);

	                Customer customer = new Customer(name, numAdults, numChildren, numDays);
	                int totalCost = customer.calculateTotalCost();

	                if (totalCost == -1) {
	                    System.out.println("Invalid input for number of adults");
	                } else if (totalCost == -2) {
	                    System.out.println("Invalid input for number of children");
	                } else if (totalCost == -3) {
	                    System.out.println("Invalid input for number of days");
	                } else {
	                    System.out.println(name + " your booking is confirmed and the total cost is " + totalCost);
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input format");
	            }
	        }
	    }
	}


