package fullStackdeveloper;
// demonstrate program on Shopping Cart - ArrayList

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;

class Products {
	    private List<String> productList = new ArrayList<>();

	    public void addProductToList(String product) {
	        productList.add(product);
	    }

	    public void sortProductList() {
	        Collections.sort(productList);
	    }

	    public List<String> getProductList() {
	        return productList;
	    }
	}

	public class  ShoppingCart {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Products cart = new Products();

	        while (true) {
	            System.out.println("1.Add");
	            System.out.println("2.Display");
	            System.out.println("3.Exit");
	            System.out.println("Enter your choice ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter the product");
	                    scanner.nextLine(); // Consume the newline character
	                    String product = scanner.nextLine();
	                    cart.addProductToList(product);
	                    break;
	                case 2:
	                    List<String> productList = cart.getProductList();
	                    if (productList.isEmpty()) {
	                        System.out.println("The list is empty");
	                    } else {
	                        cart.sortProductList();
	                        for (String item : productList) {
	                            System.out.println(item);
	                        }
	                    }
	                    break;
	                case 3:
	                    System.out.println("Thank you for using the application");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please select a valid option.");
	            }
	        }
	    }
	}

