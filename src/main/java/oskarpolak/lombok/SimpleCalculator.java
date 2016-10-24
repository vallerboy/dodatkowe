package oskarpolak.lombok;

import java.util.Scanner;

public class SimpleCalculator {
 
	 private Scanner scanner; 
	  
	 public SimpleCalculator() {
		 
		 scanner = new Scanner(System.in);
		 
		 
	 }
	 

	 
	 public int addition(int first, int second) { 
		 return first + second;
		  
	 }
	  
	
	 
	 
}
