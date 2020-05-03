package Project6;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface studentGraph;
	private String[] townStudent;
	  
	@Before
	public void setUp() throws Exception {
		  studentGraph = new TownGraphManager();
		  townStudent = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  townStudent[i] = "Town" + i;
			  studentGraph.addTown(townStudent[i]);
		  }
		  
		  studentGraph.addRoad(townStudent[1], townStudent[2], 2, "Road9");
		  studentGraph.addRoad(townStudent[1], townStudent[3], 4, "Road12");
		  studentGraph.addRoad(townStudent[1], townStudent[5], 6, "Road7");
		  studentGraph.addRoad(townStudent[3], townStudent[7], 1, "Road3");
		  studentGraph.addRoad(townStudent[3], townStudent[8], 2, "Road8");
		  studentGraph.addRoad(townStudent[4], townStudent[8], 3, "Road6");
		  studentGraph.addRoad(townStudent[6], townStudent[9], 3, "Road2");
		  studentGraph.addRoad(townStudent[9], townStudent[10], 4, "Road11");
		  studentGraph.addRoad(townStudent[8], townStudent[10], 2, "Road10");
		  studentGraph.addRoad(townStudent[5], townStudent[10], 5, "Road4");
		  studentGraph.addRoad(townStudent[10], townStudent[11], 3, "Road1");
		  studentGraph.addRoad(townStudent[2], townStudent[11], 6, "Road5");
		 
	}

	@After
	public void tearDown() throws Exception {
		studentGraph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = studentGraph.allRoads();
		assertEquals("Road1", roads.get(0));
		assertEquals("Road10", roads.get(1));
		assertEquals("Road11", roads.get(2));
		assertEquals("Road12", roads.get(3));
		studentGraph.addRoad(townStudent[4], townStudent[11], 1,"Road13");
		roads = studentGraph.allRoads();
		assertEquals("Road1", roads.get(0));
		assertEquals("Road10", roads.get(1));
		assertEquals("Road11", roads.get(2));
		assertEquals("Road12", roads.get(3));
		assertEquals("Road13", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road5", studentGraph.getRoad(townStudent[2], townStudent[11]));
		assertEquals("Road3", studentGraph.getRoad(townStudent[3], townStudent[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, studentGraph.containsTown("Town12"));
		studentGraph.addTown("Town12");
		assertEquals(true, studentGraph.containsTown("Town12"));
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, studentGraph.containsTown("Town2"));
		assertEquals(false, studentGraph.containsTown("Town12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, studentGraph.containsRoadConnection(townStudent[2], townStudent[11]));
		assertEquals(false, studentGraph.containsRoadConnection(townStudent[3], townStudent[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = studentGraph.allRoads();
		assertEquals("Road1", roads.get(0));
		assertEquals("Road10", roads.get(1));
		assertEquals("Road11", roads.get(2));
		assertEquals("Road8", roads.get(10));
		assertEquals("Road9", roads.get(11));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, studentGraph.containsRoadConnection(townStudent[2], townStudent[11]));
		studentGraph.deleteRoadConnection(townStudent[2], townStudent[11], "Road5");
		assertEquals(false, studentGraph.containsRoadConnection(townStudent[2], townStudent[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, studentGraph.containsTown("Town2"));
		studentGraph.deleteTown(townStudent[2]);
		assertEquals(false, studentGraph.containsTown("Town2"));
	}

	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = studentGraph.allTowns();
		assertEquals("Town1", roads.get(0));
		assertEquals("Town10", roads.get(1));
		assertEquals("Town11", roads.get(2));
		assertEquals("Town2", roads.get(3));
		assertEquals("Town8", roads.get(9));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = studentGraph.getPath(townStudent[1],townStudent[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town1 via Road9 to Town2 2 miles",path.get(0).trim());
		  assertEquals("Town2 via Road5 to Town11 6 miles",path.get(1).trim());
		  assertEquals("Total miles: 8 miles",path.get(2).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = studentGraph.getPath(townStudent[1],townStudent[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town1 via Road12 to Town3 4 miles",path.get(0).trim());
		  assertEquals("Town3 via Road8 to Town8 2 miles",path.get(1).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = studentGraph.getPath(townStudent[1],townStudent[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town1 via Road12 to Town3 4 miles",path.get(0).trim());
		  assertEquals("Town3 via Road8 to Town8 2 miles",path.get(1).trim());
		  assertEquals("Town8 via Road10 to Town10 2 miles",path.get(2).trim());
		 

	}
}