package fullStackdeveloper;
// Demonstrate Program on Danny's Details using Files


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	class Details {
	    public String readNames(String filename) {
	        Properties properties = new Properties();
	        String concatenatedName = "";

	        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
	            properties.load(fileInputStream);
	            String firstName = properties.getProperty("firstName");
	            String lastName = properties.getProperty("lastName");

	            concatenatedName = firstName + " " + lastName;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return concatenatedName;
	    }
	}

	public class DannysDetails  {
	    public static void main(String[] args) {
	        String filename = "DannyDetails/details.properties";
	        Details details = new Details();

	        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
	            Properties properties = new Properties();
	            properties.load(fileInputStream);

	            // Print all the properties from the file
	            properties.forEach((key, value) -> System.out.println(value));

	            String fullName = details.readNames(filename);

	            // Display the concatenated first name and last name
	            System.out.println(fullName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
