package fullStackdeveloper;
// Program to Demonstrate the Find Letters
import java.util.Scanner;
public class FindLetters {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("Enter the word");
    	  String word = sc.nextLine();
    	  System.out.println("Enter the two indices");
    	  int index1 = sc.nextInt();
    	  if(index1< 0 || index1 >= word.length()) {
    		  System.out.println(index1+ " is greater than the word length");
    	  }else {
    		  
    	int index2 = sc.nextInt();
    	if(index2>= word.length()) {
    	System.out.println(index2+ " is greater than the word length");
    	}else if(index1>=index2) {
    		System.out.println("Index2 should be greater than Index1");
    	}else {
    		String result = word.substring(index1,index2);
    		System.out.println(result);
    	}
    	  }
      sc.close();
      }
}