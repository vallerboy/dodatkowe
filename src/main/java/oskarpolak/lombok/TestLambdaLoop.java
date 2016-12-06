package oskarpolak.lombok;

import java.util.ArrayList;
import java.util.List;

public class TestLambdaLoop {
     
	 
	 public TestLambdaLoop() { 
		   
		  List<String> ourData = new ArrayList<String>(5);
		  ourData.add("Jestem");
		  ourData.add("Byłem");
		  ourData.add("Będę");
		  ourData.add("AkademiaKodu.pl");
		  
		  
		  long startTimeClassic = System.nanoTime();
		  for(int i = 0; i < ourData.size(); i++){
			  System.out.println(ourData.get(i));
		  }
		  long stopTimeClassic = System.nanoTime();
		  
		  long startTimeLambda = System.nanoTime();
		  ourData.stream().forEach((String s) -> System.out.println(s));
		  long stopTimeLambda = System.nanoTime();
		  
		 
		  
		  System.out.println("Lambda wykonała się w : " + (stopTimeLambda - startTimeLambda) + " ms.");
		  System.out.println("Zwykła pętla wykonała się w : " + (stopTimeClassic - startTimeClassic) + " ms.");
	 }
	
}
