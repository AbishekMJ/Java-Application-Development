package fullStackdeveloper;
//Program to demonstrate Country wise population - Code Analysis on Strings
import java.util.Scanner;
public class  CountryWisePopulation{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the total number of countries that need to be added to the array");
	        int numCountries = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline

	        String[] countries = new String[numCountries];
	        int[] populations = new int[numCountries];

	        System.out.println("Enter the names of the countries");
	        for (int i = 0; i < numCountries; i++) {
	            countries[i] = scanner.nextLine();
	        }

	        System.out.println("Enter the population of each country in the same array-order as the country names");
	        for (int i = 0; i < numCountries; i++) {
	            populations[i] = scanner.nextInt();
	        }

	        sortCountriesByPopulation(countries, populations);

	        for (int i = 0; i < numCountries; i++) {
	            System.out.println(countries[i] + "-" + populations[i]);
	        }
	    }

	    public static void sortCountriesByPopulation(String[] countries, int[] populations) {
	        int n = populations.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (populations[j] > populations[j + 1]) {
	                    // Swap the population values
	                    int tempPopulation = populations[j];
	                    populations[j] = populations[j + 1];
	                    populations[j + 1] = tempPopulation;

	                    // Swap the country names
	                    String tempCountry = countries[j];
	                    countries[j] = countries[j + 1];
	                    countries[j + 1] = tempCountry;
	                }
	            }
	        }
	    }
	}
