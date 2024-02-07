/**
 * BreadthFirstSearch class
 * @author Stack Overflow / Carter Bartz
 * @version 1.0
 */

import java.util.*;

public class BreadthFirstSearch {
    
    // Graph object
    private Graph graph;
    // Visited array
    private boolean[] visited;
    // Distance array
    private int[] distTo;
    // Edge array
    private String[] edgeTo;

    /**
     * Constructor
     * @param graph Graph object
     */
    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVertexCount()];
        distTo = new int[graph.getVertexCount()];
        edgeTo = new String[graph.getVertexCount()];
    }

    /**
     * Breadth-first search
     * @param startVertex Starting vertex
     */
    private void bfs(String startVertex) {
        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        // Mark the current node as visited and enqueue it
        int rootIndex = graph.findIndex(startVertex);
        visited[rootIndex] = true;
        queue.add(startVertex);
        // While queue is not empty
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            String currentVertex = queue.poll();
            // Get all adjacent vertices of the dequeued vertex s
            int currentIndex = graph.findIndex(currentVertex);
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (int i = 0; i < graph.getVertexCount(); i++) {
                // If an adjacent vertex is adjacent and has not been visited
                if (graph.getAdjacencyMatrix()[currentIndex][i] && !visited[i]) {
                    // Mark it visited
                    visited[i] = true;
                    // Set distTo
                    distTo[i] = distTo[currentIndex] + 1;
                    // Set edgeTo
                    edgeTo[i] = currentVertex;
                    // Enqueue it
                    queue.add(graph.getVertices()[i]);
                }
            }
        }
    }

    /**
     * Shortest path from startVertex to endVertex
     * @param startVertex Starting vertex
     * @param endVertex Ending vertex
     * @return Shortest path from startVertex to endVertex
     */
    public List<String> shortestPathFromTo(String startVertex, int distance) {
        //call bfs recursively
        bfs(startVertex);
        //return shortest path
        List<String> result = new ArrayList<>();
        // Find all paths with distance
        for (int i = 0; i < graph.getVertexCount(); i++) {
            // If the distance is the same as the distance to the end vertex
            if (distTo[i] == distance) {
                // Get the path
                String path = "";
                int currentIndex = i;
                // While the current index is not the start vertex
                while (!graph.getVertices()[currentIndex].equals(startVertex)) {
                    // Add the current vertex to the path
                    path = graph.getVertices()[currentIndex] + "-" + path;
                    currentIndex = graph.findIndex(edgeTo[currentIndex]);
                }
                // Add the start vertex to the path
                path = startVertex + "-" + path;
                result.add(path.substring(0, path.length() - 1));
            }
        }
        return result;
    }
}
