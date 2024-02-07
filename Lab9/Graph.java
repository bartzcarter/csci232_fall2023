/**
 * Graph data structure using adjacency matrix
 * @version 1.0
 * @author Carter Bartz - referncing Stack Overflow
 */

 class Graph {
    //vertices is an array of strings that holds the names of the vertices
    private String[] vertices;
    //adjacencyMatrix is a 2D array of booleans that holds the adjacency matrix
    private boolean[][] adjacencyMatrix;
    //vertexCount is an integer that holds the number of vertices in the graph
    private int vertexCount;

    /**
     * Constructor for the Graph class
     * @param numberOfVertices the number of vertices in the graph
     * @return Graph object
     */
    public Graph(int numberOfVertices) {
        this.vertices = new String[numberOfVertices];
        this.adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
        this.vertexCount = 0;
    }

    /**
     * Adds a vertex to the graph
     * @param vertex the vertex to add
     */
    public void addVertex(String vertex) {
        // Check if the vertex is already in the graph
        if (findIndex(vertex) == -1) {
            // Add the vertex to the vertices array
            vertices[vertexCount] = vertex;
            // Increment the vertex count
            vertexCount++;
        }
    }

    /**
     * Adds an edge to the graph
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public void addEdge(String vertex1, String vertex2) {
        // Find the index of the vertices
        int idx1 = findIndex(vertex1);
        int idx2 = findIndex(vertex2);

        // If both vertices are in the graph, add the edge
        if (idx1 != -1 && idx2 != -1) {
            adjacencyMatrix[idx1][idx2] = true;
            adjacencyMatrix[idx2][idx1] = true;
        }
    }

    /**
     * Removes an edge from the graph
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public String[] getVertices() {
        return vertices;
    }

    /**
     * Returns the adjacency matrix
     * @return adjacency matrix
     */
    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * Returns the index of a vertex
     * @param vertex the vertex to find
     * @return the index of the vertex
     */
    public int findIndex(String vertex) {
        // Loop through the vertices array
        for (int i = 0; i < vertexCount; i++) {
            // If the vertex is found, return the index
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        // If the vertex is not found, return -1
        return -1;
    }

    /**
     * Returns the number of vertices in the graph
     * @return the number of vertices in the graph
     */
    public int getVertexCount() {
        return vertexCount;
    }
}
