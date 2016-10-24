package oskarpolak.lombok;

import java.util.regex.Pattern;

public class Regex {
 
	   public Regex() {

		   // Sprwadzamy czy druga litera wynosi "a".
		   System.out.println(Pattern.matches(".s", "as"));  
		   
           // Sprawdzamy czy wyrażenie zawiera więcej niż jeden nondigit
		   System.out.println(Pattern.matches("\\D+", "aaa")); 
		    
	   
	   }
	   
}
