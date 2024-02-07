/**
 * Driver class for the BreadthFirstSearch class - lab 10
 * @author Carter Bartz
 * @version 1.0
 */

import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // Read the input file
        try {
            Scanner scanner = new Scanner(new File("inlab9.txt"));

            // Read the number of vertices and edges
            int numberOfVertices = scanner.nextInt(); // Read the number of vertices
            int numberOfEdges = scanner.nextInt(); // Read the number of edges
            scanner.nextLine(); // Move to the next line

            // Create a graph with the number of vertices
            Graph graph = new Graph(numberOfVertices); // Pass the number of vertices to the constructor

            // Read the vertices
            for (int i = 0; i < numberOfEdges; i++) {
                // Read the line
                String line = scanner.nextLine();
                String[] states = line.split(" ");

                // Add the vertices to the graph
                String state1 = states[0];
                String state2 = states[1];

                graph.addVertex(state1);
                graph.addVertex(state2);
                graph.addEdge(state1, state2);
            }
            // Close the scanner
            scanner.close();

            // Create BreadthFirstSearch object
            BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
            String startVertex = "Montana";

            // Write the output to a file
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            // Find paths 2 distances away
            List<String> result2 = bfs.shortestPathFromTo(startVertex, 2);
            for (String path : result2) {
                String[] states = path.split("-");
                writer.write("Montana to " + states[states.length - 1] + " (2): " + path + "\n");
            }

            // Find paths 3 distances away
            List<String> result3 = bfs.shortestPathFromTo(startVertex, 3);
            for (String path : result3) {
                String[] states = path.split("-");
                writer.write("Montana to " + states[states.length - 1] + " (3): " + path + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
