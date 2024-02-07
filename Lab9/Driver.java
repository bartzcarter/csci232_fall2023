/**
 * Driver class for the Graph class - used to determine the neighbors of each state
 * @version 1.0
 * @author Carter Bartz
 */
import java.io.*;
import java.util.Scanner;

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

            // Print the adjacency matrix
            String[] vertices = graph.getVertices();

            // Write the neighbors to a file
            boolean[][] adjacencyMatrix = graph.getAdjacencyMatrix();

            // Get the vertex count
            int vertexCount = graph.getVertexCount();

            // Write the neighbors to a file
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            //loop through the vertices
            for (int i = 0; i < vertexCount; i++) {
                writer.write(vertices[i] + ": ");
                //loop through the adjacency matrix
                for (int j = 0; j < vertexCount; j++) {
                    //if the vertex is adjacent, write it to the file
                    if (adjacencyMatrix[i][j]) {
                        writer.write(vertices[j]);
                        //if it's not the last vertex, add a comma
                        if (j < vertexCount - 1) {
                            writer.write(", ");
                        }
                    }
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
