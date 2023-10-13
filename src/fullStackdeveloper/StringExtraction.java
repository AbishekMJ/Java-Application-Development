package fullStackdeveloper;
// demonstrate the program to String Extraction (Finally)

import java.util.Scanner;

public class StringExtraction{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the String");
        String sentence = scanner.nextLine();
        
        System.out.println("Enter First Index");
        int number1 = scanner.nextInt();
        
        System.out.println("Enter Second Index");
        int number2 = scanner.nextInt();
        
        try {
            String result = extractString(sentence, number1, number2);
            System.out.println(result);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid index position.");
        } finally {
            System.out.println("Thanks for using the application.");
        }
    }
    
    public static String extractString(String sentence, int number1, int number2) {
        try {
            if (number1 < 0 || number2 < 0 || number1 >= sentence.length() || number2 > sentence.length()) {
                throw new StringIndexOutOfBoundsException();
            }
            
            String extracted = sentence.substring(number1, number2);
            return "The output string is " + extracted + ".";
        } catch (StringIndexOutOfBoundsException e) {
            throw e;
        }
    }
}
