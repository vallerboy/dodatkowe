package oskarpolak.lombok;

import org.junit.Test;

import junit.framework.TestCase;

public class SimpleCalculatorTest extends TestCase {
    
	 
	@Test
	public void testDodawanie(){ 
		 SimpleCalculator cal = new SimpleCalculator();
		 cal.addition(2121412323,2131213213);
		 assertEquals(1231242141, 0);
	}
}
