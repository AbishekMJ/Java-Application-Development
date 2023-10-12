package fullStackdeveloper;
// program to demonstrate Vivek Furnitures - Polymorphism
import java.util.Scanner;
	// CustomerDetails class to store customer information
	class CustomerDetails {
	    private String customerName;
	    private long phoneNumber;
	    private String address;

	    public CustomerDetails(String customerName, long phoneNumber, String address) {
	        this.customerName = customerName;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	    }

	    // Getter and setter methods for customer details
	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public long getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(long phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	}

	// Abstract Bero class
	abstract class Bero {
	    protected String beroType;
	    protected String beroColour;
	    protected double price;

	    public Bero(String beroType, String beroColour) {
	        this.beroType = beroType;
	        this.beroColour = beroColour;
	    }

	    public abstract void calculatePrice();

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }
	}

	// SteelBero class, a child of Bero
	class SteelBero extends Bero {
	    private int beroHeight;

	    public SteelBero(String beroType, String beroColour, int beroHeight) {
	        super(beroType, beroColour);
	        this.beroHeight = beroHeight;
	    }

	    @Override
	    public void calculatePrice() {
	        if (beroHeight == 3) {
	            setPrice(5000);
	        } else if (beroHeight == 5) {
	            setPrice(8000);
	        } else if (beroHeight == 7) {
	            setPrice(10000);
	        }
	    }
	}

	// WoodenBero class, a child of Bero
	class WoodenBero extends Bero {
	    private String woodType;

	    public WoodenBero(String beroType, String beroColour, String woodType) {
	        super(beroType, beroColour);
	        this.woodType = woodType;
	    }

	    @Override
	    public void calculatePrice() {
	        switch (woodType) {
	            case "Ply Wood":
	                setPrice(15000);
	                break;
	            case "Teak Wood":
	                setPrice(12000);
	                break;
	            case "Engineered Wood":
	                setPrice(10000);
	                break;
	            default:
	                setPrice(0);
	                break;
	        }
	    }
	}

	// Discount class to calculate discount
	class Discount {
	    public double calculateDiscount(Bero bObj) {
	        if (bObj instanceof SteelBero) {
	            return (bObj.getPrice() * 10) / 100;
	        } else if (bObj instanceof WoodenBero) {
	            return (bObj.getPrice() * 15) / 100;
	        }
	        return 0;
	    }
	}

	// UserInterface class to test the application
	public class VivekFurnitures{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Get customer details
	        System.out.println("Enter Customer Name");
	        String customerName = scanner.nextLine();

	        System.out.println("Enter Phone Number");
	        long phoneNumber = scanner.nextLong();
	        scanner.nextLine(); // Consume the newline character

	        System.out.println("Enter address");
	        String address = scanner.nextLine();

	        CustomerDetails customer = new CustomerDetails(customerName, phoneNumber, address);

	        // Get bero type
	        System.out.println("Enter Bero Type");
	        String beroType = scanner.nextLine();

	        // Check and create the appropriate Bero object
	        Bero bero = null;
	        if (beroType.equals("Steel Bero")) {
	            System.out.println("Enter Bero Colour");
	            String beroColour = scanner.nextLine();

	            System.out.println("Enter Bero Height");
	            int beroHeight = scanner.nextInt();

	            bero = new SteelBero(beroType, beroColour, beroHeight);
	        } else if (beroType.equals("Wooden Bero")) {
	            System.out.println("Enter Bero Colour");
	            String beroColour = scanner.nextLine();

	            System.out.println("Enter Wood Type");
	            String woodType = scanner.nextLine();

	            bero = new WoodenBero(beroType, beroColour, woodType);
	        } else {
	            System.out.println(beroType + " is an invalid bero type");
	            scanner.close();
	            return;
	        }

	        // Calculate price and discount
	        bero.calculatePrice();
	        Discount discountCalculator = new Discount();
	        double discount = discountCalculator.calculateDiscount(bero);
	        double totalPrice = bero.getPrice() - discount;

	        // Display the amount to be paid
	        System.out.printf("Amount needs to be paid %.2f%n", totalPrice);

	        scanner.close();
	    }
	}

