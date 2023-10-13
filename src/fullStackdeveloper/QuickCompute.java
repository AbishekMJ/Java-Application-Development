package fullStackdeveloper;
// program to demonstrate on Quick Compute - TreeSet
import java.util.Scanner;
import java.util.TreeSet;

public class QuickCompute{
    private TreeSet<Integer> numSet = new TreeSet<>();

    public void addNum(int num) {
        if (num % 5 != 0 && num % 6 != 0) {
            numSet.add(num);
        }
    }

    public double calAvg() {
        if (numSet.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int num : numSet) {
            sum += num;
        }

        return (double) sum / numSet.size();
    }

    public TreeSet<Integer> getNumSet() {
        return numSet;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuickCompute numAvg =  new QuickCompute();

        while (true) {
            System.out.println("1.Add number");
            System.out.println("2.Find average");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number");
                    int num = scanner.nextInt();
                    numAvg.addNum(num);
                    break;
                case 2:
                    TreeSet<Integer> numSet = numAvg.getNumSet();
                    if (numSet.isEmpty()) {
                        System.out.println("The set is empty");
                    } else {
                        double average = numAvg.calAvg();
                        System.out.println(average);
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

