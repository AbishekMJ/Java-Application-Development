package fullStackdeveloper;

// Program to demonstrate the Fresh Farm - Streams
import java.util.*;
import java.util.stream.Stream;

class Carton {
    private String productName;
    private int quantity;
    private double productCost;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }
}

class CartonUtility {
    private List<Carton> cartonList = new ArrayList<>();

    public List<Carton> getCartonList() {
        return cartonList;
    }

    public void setCartonList(List<Carton> cartonList) {
        this.cartonList = cartonList;
    }

    public Stream<Carton> convertToStream() {
        return cartonList.stream();
    }

    public Carton findMax(Stream<Carton> stream1) {
        return stream1.max(Comparator.comparingInt(Carton::getQuantity))
                .orElse(null);
    }
}

public class FreshFarm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CartonUtility cartonUtility = new CartonUtility();

        System.out.println("Enter the number of cartons");
        int numCartons = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (numCartons <= 0) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Enter carton details");
        for (int i = 0; i < numCartons; i++) {
            String input = scanner.nextLine();
            String[] cartonInfo = input.split("/");

            if (cartonInfo.length != 3) {
                System.out.println("Invalid input format");
                return;
            }

            String productName = cartonInfo[0];
            int quantity;
            double productCost;

            try {
                quantity = Integer.parseInt(cartonInfo[1]);
                productCost = Double.parseDouble(cartonInfo[2]);
            } catch (NumberFormatException e) {
                System.out.println("Quantity number should be a valid number");
                return;
            }

            if (quantity <= 0) {
                System.out.println("Quantity number should be a valid number");
                return;
            }

            Carton carton = new Carton();
            carton.setProductName(productName);
            carton.setQuantity(quantity);
            carton.setProductCost(productCost);

            cartonUtility.getCartonList().add(carton);
        }

        Carton maxCarton = cartonUtility.findMax(cartonUtility.convertToStream());
        if (maxCarton != null) {
            System.out.println(maxCarton.getProductName() + " had the highest quantity with " + maxCarton.getQuantity() + " nos");
        } else {
            System.out.println("No cartons found");
        }
    }
}