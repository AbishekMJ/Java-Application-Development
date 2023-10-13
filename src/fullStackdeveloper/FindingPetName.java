package fullStackdeveloper;
// Program to demonstrate Finding Pet Name - Try With Resources
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;

	public class FindingPetName  {
	    public static void main(String[] args) {
	        String fileName = "petNames.txt"; // Change this to the actual file name

	        try {
	            String petName = findPetName(fileName);
	            System.out.println(petName);
	        } catch (FileNotFoundException e) {
	            System.out.println("Please give the correct file name");
	        } catch (IOException e) {
	            System.out.println("Error occurred while reading the names from the file");
	        }
	    }

	    public static String findPetName(String fileName) throws IOException {
	        try (FileReader fileReader = new FileReader(fileName);
	             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                line = line.trim();
	                if (countVowels(line) == 2) {
	                    return line;
	                }
	            }
	        }
	        return null; // If no name with exactly two vowels is found
	    }

	    public static int countVowels(String name) {
	        int count = 0;
	        for (char c : name.toCharArray()) {
	            if ("AEIOUaeiou".contains(String.valueOf(c))) {
	                count++;
	            }
	        }
	        return count;
	    }
	}
