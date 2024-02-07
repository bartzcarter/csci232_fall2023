/**
 * Depth First Search class to find the longest increasing subsequence in a graph.
 * @author Carer Bartz from Stack Overflow
 * @version 1.0
 */

public class DFS {

    /**
     * Finds the longest increasing subsequence in a graph
     * @param graph the graph
     * @return the length of the longest increasing subsequence
     */
    public int findLongestIncreasingSubsequence(Graph graph) {
        // Get the number of vertices in the graph
        int numVertices = graph.getVertexCount();
        // Initialize the max path length to 0
        int maxPathLength = 0;

        // For each vertex in the graph, find the longest path
        for (int i = 0; i < numVertices; i++) {
            maxPathLength = Math.max(maxPathLength, dfs(graph, i));
        }
        return maxPathLength;
    }

    /**
     * Finds the longest increasing subsequence in a graph
     * @param graph the graph
     * @param vertex the vertex
     * @return the length of the longest increasing subsequence
     */
    private int dfs(Graph graph, int vertex) {
        // Initialize the max path length to 1
        int maxPathLength = 1;

        // Get the adjacency matrix for the graph
        boolean[] adjMatrix = graph.getAdjacencyMatrix()[vertex];
        // For each vertex in the graph, find the longest path
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[i] && Integer.parseInt(graph.getVertices()[i]) > Integer.parseInt(graph.getVertices()[vertex])) {
                maxPathLength = Math.max(maxPathLength, 1 + dfs(graph, i));
            }
        }
        return maxPathLength;
    }
}
