import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BreadthFirstSearch {
    private Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public String[] shortestPathFromTo(String startVertex, int distance) {
        int start = graph.findIndex(startVertex);
        if (start == -1) {
            System.out.println("Start vertex not found.");
            return new String[0];
        }

        int vertexCount = graph.getVertexCount();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        int[] distTo = new int[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
            distTo[i] = Integer.MAX_VALUE;
        }

        queue.add(start);
        visited[start] = true;
        distTo[start] = 0;

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
                if (graph.getAdjacencyMatrix()[current][neighbor] && !visited[neighbor]) {
                    visited[neighbor] = true;
                    distTo[neighbor] = distTo[current] + 1;
                    queue.add(neighbor);

                    if (distTo[neighbor] == distance) {
                        result.add(graph.getVertices()[neighbor]);
                    }
                }
            }
        }

        String[] resultArray = new String[result.size()];
        return result.toArray(resultArray);
    }
}
