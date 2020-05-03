package Project6;

/**
 * Private unit tests for the Town class.
 * @author 
 */

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test{
	
	Town town1, town2;
	  
	@Before
	public void setUp() throws Exception {
		town1 = new Town("Washington");
		town2 = new Town("Dallas");
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testNames() {
		assertEquals("Washington", town1.getName());
		assertEquals("Dallas", town2.getName());
	}
	
	
	@Test
	public void testEquals() {
		assertEquals(false, town1.equals(town2));
		assertEquals(true, town1.equals(town1));
	}

	
	
	@Test
	public void testCompare() {
		assertEquals(true, town1.compareTo(town2) > 0);
		assertEquals(0, town1.compareTo(town1));
	}



}
