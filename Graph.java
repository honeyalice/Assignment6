package Project6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A graph that connects towns vis roads.
 * @author Bingying Jiang
 */
public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns;
    private Set<Road> roads;
    private Map<String, Town> prevTown;
    
    /**
     * set up a graph
     */
    public Graph() {
    	this.towns = new HashSet<>();
    	this.roads = new HashSet<>();
    	this.prevTown = new HashMap<>();
    }

    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns null. If
     * any of the specified vertices is null returns null
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        for (Road r : roads) {
            if ((sourceVertex.equals(r.getT1()) || sourceVertex.equals(r.getT2()))&&
            		(destinationVertex.equals(r.getT2()) || destinationVertex.equals(r.getT1()))
            		) {
                return r;
            }
        }
        return null;
    }

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge.
     *
     * The source and target vertices must already be contained in this graph.
     * If they are not found in graph IllegalArgumentException is thrown.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
    	if (containsEdge(sourceVertex, destinationVertex)) {
            return null;
        }
    	if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
            throw new IllegalArgumentException();}
    	if (sourceVertex == null || destinationVertex == null || description == null) {
            throw new NullPointerException();
        }
        Road r = new Road(sourceVertex, destinationVertex, weight, description);
        roads.add(r);
        return r;
        
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if this graph
     * contains no vertex u such that u.equals(v). If this graph already
     * contains such vertex, the call leaves this graph unchanged and returns
     * false. In combination with the restriction on constructors, this ensures
     * that graphs never contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    @Override
    public boolean addVertex(Town v) {
        towns.add(v);
        if (containsVertex(v)) {
            return false;
        }
        if (v == null) {
            throw new NullPointerException();
        }
        return true;
    }

    /**
     * Returns true if and only if this graph contains an edge going from the
     * source vertex to the target vertex. In undirected graphs the same result
     * is obtained when source and target are inverted. If any of the specified
     * vertices does not exist in the graph, or if is null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        for (Road r : roads) {
            if ((sourceVertex.equals(r.getT1()) || sourceVertex.equals(r.getT2()))
                    && (destinationVertex.equals(r.getT2()) || destinationVertex.equals(r.getT1()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this graph contains the specified vertex. More formally,
     * returns true if and only if this graph contains a vertex u such that
     * u.equals(v). If the specified vertex is null returns false.
     *
     * @param u vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    @Override
    public boolean containsVertex(Town v) {
        for (Town u : towns) {
            if (u.equals(v)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     * @return a set of the edges contained in this graph.
     */
    @Override
    public Set<Road> edgeSet() {
        return roads;
    }

    /**
     * Returns a set of all edges touching the specified vertex (also referred
     * to as adjacent vertices). If no edges are touching the specified vertex
     * returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> e = new HashSet<>();
    	if (!containsVertex(vertex)) {
            throw new IllegalArgumentException();
        }
        if (vertex == null) {
            throw new NullPointerException();
        }
        for (Road r : roads) {
            if (r.getT1().equals(vertex) || r.getT2().equals(vertex)) {
                e.add(r);
            }
        }
        return e;
    }

    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph.
     *
     * If weight less than -1 it must be checked If description != null, it must be
     * checked
     *
     * Returns the edge if removed or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road removeE = new Road(sourceVertex, destinationVertex, weight, description);
       Road foundE = null;
        for (Road r : roads) {
           if (r.equals(removeE)) {
               foundE = r;
             break;
           }
       }
        if (foundE != null) {
           roads.remove(foundE);
      }
        return foundE;
    }
    	//for (Road r : roads) {
    		//if (((Road) r).getT1().equals(sourceVertex) && ((Road) r).getT2().equals(destinationVertex)) {
    		//roads.remove(r);
    		//return (Road) r;
    		//}}
    		//return null;
    		//}

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex u such
     * that u.equals(v), the call removes all edges that touch u and then
     * removes u itself. If no such u is found, the call leaves the graph
     * unchanged. Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex; false
     * otherwise.
     */
    @Override
    public boolean removeVertex(Town v) {
        Town T = null;
        for (Town t : towns) {
            if (t.equals(v)) {
                T = t;
            }
        }
        if (T != null) {
            towns.remove(T);
            return true;
        }
        return false;
    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
    @Override
    public Set<Town> vertexSet() {
        return towns;
    }

    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     *
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     */
    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        ArrayList<String> path = new ArrayList<>();
        dijkstraShortestPath(sourceVertex);
        Town newTown = destinationVertex;
        while (!newTown.equals(sourceVertex)) {
            if (!prevTown.containsKey(newTown.getName())) {
                path.clear();
                break;
            }
            Town parentTown = prevTown.get(newTown.getName());
            Road r = getEdge(parentTown, newTown);
            path.add(0, parentTown.getName() + " via " + r.getName() + " to " + newTown.getName() + " " + r.getDegrees() + " mi");
            newTown = parentTown;
        }
        return path;
    }

    /**
     * Dijkstra's Shortest Path Method. Internal structures are built which hold
     * the ability to retrieve the path, shortest distance from the sourceVertex
     * to all the other vertices in the graph, etc.
     *
     * @param sourceVertex the vertex to find shortest path from
     *
     */
    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
        Set<Town> explored = new HashSet<>();
        List<Town> unvisitedTown = new ArrayList<>();
        HashMap<String, Integer> cost = new HashMap<>();
        prevTown.clear();

        for (Town t : towns) {
            unvisitedTown.add(t);
            cost.put(t.getName(), Integer.MAX_VALUE);
            prevTown.put(t.getName(), null);
        }
        cost.put(sourceVertex.getName(), 0);
        System.out.println(unvisitedTown);
        System.out.println(cost + "\n");
        while (!unvisitedTown.isEmpty()) {
            int lowestCostIndex = 0;

            for (int i = 1; i < unvisitedTown.size(); i++) {
                Town unvisitedVertex = unvisitedTown.get(i);

                if (cost.get(unvisitedVertex.getName()) < cost.get(unvisitedTown.get(lowestCostIndex).getName())) {
                    lowestCostIndex = i;
                }
            }

            // Remove the lowest cost node from the unvisited nodes to be marked as visited
            Town lowestCostVertex = unvisitedTown.remove(lowestCostIndex);
            explored.add(lowestCostVertex);

            // If the lowest cost is infinity, then all remaining vertices is inaccessible
            if (cost.get(lowestCostVertex.getName()) == Integer.MAX_VALUE) {
                return;
            }

            // Calculate the distance from the chosen node to adjacent ones that haven't 
            // yet been removed from the graph
            for (Road r : edgesOf(lowestCostVertex)) {
                Town neighbor = r.getT2();

                if (neighbor.equals(lowestCostVertex)) {
                    neighbor = r.getT1();
                }

                if (explored.contains(neighbor)) {
                    continue;
                }

                int adjacentCost = cost.get(lowestCostVertex.getName()) + r.getDegrees();

                // Replace the neighbor with better cost
                if (adjacentCost < cost.get(neighbor.getName())) {
                    cost.put(neighbor.getName(), adjacentCost);
                    prevTown.put(neighbor.getName(), lowestCostVertex);
                }
            }
        }
    }

}
