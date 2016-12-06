package oskarpolak.lombok;

import java.util.Scanner;

public class SimpleCalculator {
 
	 
	 public SimpleCalculator() { 
		 
	 }
 
	 
	 public int addition(int first, int second) { 
		 if(first == 0 || second == 0) throw new IllegalArgumentException();
		 return first + second;
		  
	 }
	  
	
	 
	 
}
