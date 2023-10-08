package fullStackdeveloper;
//Demonstrate Java Program for getters And Setters attributes

class Product {
    private int productId;
    private String productName;
    private double price;
    private String category;

    // Constructor
    public Product(int productId, String productName, double price, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    // Getter for productId
    public int getProductId() {
        return productId;
    }

    // Setter for productId
    public void setProductId(int productId) {
        this.productId = productId;
    }

    // Getter for productName
    public String getProductName() {
        return productName;
    }

    // Setter for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }
}

public class writinggettersandsetter {
    public static void main(String[] args) {
        // Creating a Product object
        Product product = new Product(101, "Smartphone", 499.99, "Electronics");

        // Using getters to retrieve product information
        int productId = product.getProductId();
        String productName = product.getProductName();
        double price = product.getPrice();
        String category = product.getCategory();

        // Printing product information
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);

        // Using setters to update product information
        product.setPrice(549.99);
        product.setCategory("Mobile Devices");

        // Printing updated product information
        System.out.println("\nUpdated Price: $" + product.getPrice());
        System.out.println("Updated Category: " + product.getCategory());
    }
}

