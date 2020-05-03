package Project6;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class is to manage towns in a graph
 * @author Bingying Jiang
 */
public class TownGraphManager implements TownGraphManagerInterface {

    private Graph graph;
    
    /**
     * constructor initiate a empty graph
     */
    public TownGraphManager() {
    	this.graph = new Graph();
    }

    /**
     * Adds a road with 2 towns and a road name
     * @param t1 name of town 1
     * @param t2 name of town 2
     * @param roadName name of road
     * @param weight road length
     * @return true if the road was added successfully
     */
    @Override
    public boolean addRoad(String t1, String t2, int weight, String roadName) {
        return graph.addEdge(new Town(t1), new Town(t2), weight, roadName) != null;
    }

    /**
     * Returns the name of the road that both towns are connected through
     *
     * @param town1 name of town 1
     * @param town2 name of town 2
     * @return name of road if town 1 and town2 are in the same road, returns
     * null if not
     */
    @Override
    public String getRoad(String town1, String town2) {
        Road r = graph.getEdge(new Town(town1), new Town(town2));

        if (r == null) {
            return null;
        }

        return r.getName();
    }

    /**
     * Adds a town to the graph
     *
     * @param v the town's name
     * @return true if the town was successfully added, false if not
     */
    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }
    
    /**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		Town town = null;
        for (Town t : graph.vertexSet()) {
            if (t.getName().equals(name)) {
                town = t;
            }
        }
        return town;
    }

	

    /**
     * Determines if a town is already in the graph
     *
     * @param v the town's name
     * @return true if the town is in the graph, false if not
     */
    @Override
    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    /**
     * Determines if a road is in the graph
     *
     * @param town1 name of town 1
     * @param town2 name of town 2
     * @return true if the road is in the graph, false if not
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    /**
     * Creates an arraylist of all road titles in sorted order
     *
     * @return an arraylist of all road titles in sorted order
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> arr = new ArrayList<>();
        for (Road r : graph.edgeSet()) {
            if (!arr.contains(r.getName())) {
                arr.add(r.getName());
            }
        }
        Collections.sort(arr);
        return arr;
    }

    /**
     * Deletes a road from the graph
     *
     * @param town1 name of town 1
     * @param town2 name of town 2
     * @param road the road name
     * @return true if the road was successfully deleted, false if not
     */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        return graph.removeEdge(new Town(town1), new Town(town2), 1, road) != null;
    }

    /**
     * Deletes a town from the graph
     *
     * @param v name of town
     * @return true if the town was successfully deleted, false if not
     */
    @Override
    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    /**
     * Creates an arraylist of all towns in alphabetical order (last name, first
     * name)
     *
     * @return an arraylist of all towns in alphabetical order (last name, first
     * name)
     */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> arr = new ArrayList<>();

        for (Town t : graph.vertexSet()) {
            if (!arr.contains(t.getName())) {
                arr.add(t.getName());
            }
        }
        Collections.sort(arr);
        return arr;
    }

    /**
     * Returns the shortest path from town 1 to town 2
     *
     * @param town1 name of town 1 
     * @param town2 name of town 2
     * @return an Arraylist of roads connecting the two towns together, null if
     * the towns have no path to connect them.
     */
    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }

    /**
     * Reset the graph
     */
    public void clear() {
        graph = new Graph();
    }

    
		
	}

   