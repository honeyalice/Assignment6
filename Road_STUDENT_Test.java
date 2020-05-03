package Project6;

/**
 * Private tests for class Road.
 * @author 
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
	
	Road road1, road2, road3;
	Town town1, town2, town3;
	  
	@Before
	public void setUp() throws Exception {
		
		town1 = new Town("Germantown");
		town2 = new Town("Boyds");
		town3 = new Town("Olney");
		
		road1 = new Road(town1, town2, 4, "GtB");
		road2 = new Road(town1, town2, 4, "BtG");
		road2 = new Road(town1, town2, "GtB");

	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	
	@Test
	public void testContains() {
		assertEquals(true, road1.contains(town1));
		assertEquals(true, road1.contains(town2));
		assertEquals(false, road1.contains(town3));
	}
	
	
	
	
	
	

}

