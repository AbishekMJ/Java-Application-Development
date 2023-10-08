package fullStackdeveloper;
//Program to Demonstrate WalMarrt Shopping
import java.util.Scanner;

public class WalmartShopping {
    private String name;
    private long barcode;
    private String productType;
    private String productName;

    // Constructor with four arguments to initialize the values
    public WalmartShopping(String name, long barcode, String productType, String productName) {
        this.name = name;
        this.barcode = barcode;
        this.productType = productType;
        this.productName = productName;
    }

    // Getters and setters for all attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Method to calculate the total bill based on product type
    public double calculateTotalBill(double cost) {
        double tax = 0.0;

        // Calculate tax based on the product type
        if (productType.equals("ElectricalItems")) {
            tax = 0.5;
        } else if (productType.equals("Grocery")) {
            tax = 0.3;
        } else if (productType.equals("Garments")) {
            tax = 0.6;
        } else {
            System.out.println("Invalid Product Type");
            return -1.0; // Return -1 to indicate an error
        }

        // Calculate the total bill amount
        double billAmount = (cost * tax) + cost;
        return billAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Name");
        String name = scanner.nextLine();

        System.out.println("Enter the Barcode");
        long barcode = Long.parseLong(scanner.nextLine());

        System.out.println("Enter the Product Type");
        String productType = scanner.nextLine();

        System.out.println("Enter the Product Name");
        String productName = scanner.nextLine();

        System.out.println("Enter the price of the item");
        double cost = Double.parseDouble(scanner.nextLine());

        WalmartShopping walmart = new WalmartShopping(name, barcode, productType, productName);
        double billAmount = walmart.calculateTotalBill(cost);

        if (billAmount != -1.0) {
            System.out.println("Name : " + walmart.getName());
            System.out.println("Barcode : " + walmart.getBarcode());
            System.out.println("Product Type : " + walmart.getProductType());
            System.out.println("Product Name : " + walmart.getProductName());
            System.out.println("Bill Amount : " + billAmount);
        }
    }
}
