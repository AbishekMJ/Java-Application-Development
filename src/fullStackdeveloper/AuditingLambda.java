package fullStackdeveloper;
// Program to Demonstrate Auditing - Lambda using Lambda Expressions
    import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

	@FunctionalInterface
	interface EmployeeAudit {
	    ArrayList<String> fetchEmployeeDetails(double salary);
	}

	public class  AuditingLambda{
	    private static Map<String, Double> employeeMap = new HashMap<>();

	    public static void addEmployeeDetails(String employeeName, double salary) {
	        employeeMap.put(employeeName, salary);
	    }

	    public static EmployeeAudit findEmployee() {
	        return salary -> {
	            ArrayList<String> result = new ArrayList<>();
	            for (Map.Entry<String, Double> entry : employeeMap.entrySet()) {
	                if (entry.getValue() <= salary) {
	                    result.add(entry.getKey());
	                }
	            }
	            return result;
	        };
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1.Add Employee Details");
	            System.out.println("2.Find Employee Details");
	            System.out.println("3.Exit");
	            System.out.println("Enter the choice");

	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter the Employee name");
	                    String employeeName = scanner.nextLine();
	                    System.out.println("Enter the Employee Salary");
	                    double salary = scanner.nextDouble();
	                    addEmployeeDetails(employeeName, salary);
	                    break;
	                case 2:
	                    System.out.println("Enter the salary to be searched");
	                    double searchSalary = scanner.nextDouble();
	                    EmployeeAudit employeeAudit = findEmployee();
	                    ArrayList<String> employeeList = employeeAudit.fetchEmployeeDetails(searchSalary);

	                    if (employeeList.isEmpty()) {
	                        System.out.println("No Employee Found");
	                    } else {
	                        System.out.println("Employee List");
	                        for (String employee : employeeList) {
	                            System.out.println(employee);
	                        }
	                    }
	                    break;
	                case 3:
	                    System.out.println("Let's complete the session");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please select again.");
	            }
	        }
	    }
	}
