package oskarpolak.lombok;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class SimpleCalculatorTest {

    SimpleCalculator call;
	
	@Before
	public void setUp() throws Exception {
		call = new SimpleCalculator();
	}
	

	@After
	public void setDown() throws Exception {
		call = null;
	}

	@Test()
	public void testAddition() {
		
	 //  Assume.assumeFalse(System.getProperty("os.name").contains("Windows"));
	   assertEquals("Błędny wynik", 7, call.addition(5, 1), 2);
	 

	   //assertNull
	   //assertSame
	   //assertNotNull
	   //assertFalse
	   //assertTrue
	   //assertNotSame
	   //fail("błąd");
	}
	
	@Test()
	public void testRemove() {
		
	 //  Assume.assumeFalse(System.getProperty("os.name").contains("Windows"));
	   assertEquals("Błędny wynik", 7, call.remove(5, 1), 2);
	 

	   //assertNull
	   //assertSame
	   //assertNotNull
	   //assertFalse
	   //assertTrue
	   //assertNotSame
	   //fail("błąd");
	}
	
	

}
