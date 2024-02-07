/**
 * Driver class for project 3.
 * Uses DFS to find the longest increasing subsequence in a graph.
 * Uses dynamic programming to find the longest increasing subsequence in a sequence.
 * @author Carter Bartz
 * @version 1.0
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        // Generate a random sequence of 20 numbers
        int[] sequence = generateRandomSequence(20);

        // Create a graph from the sequence
        Graph graph = createGraph(sequence);

        // Create a DFS object and find the longest increasing subsequence
        DFS dfs = new DFS();

        // Find the longest increasing subsequence using DFS
        int longestPathGraph = dfs.findLongestIncreasingSubsequence(graph);
        int lisDP = findLIS(sequence);

        // Write the output to a file
        writeOutput(longestPathGraph, lisDP, Arrays.toString(sequence));
    }

    /**
     * Generates a random sequence of numbers from 1 to 20
     * @param length the length of the sequence
     * @return the sequence
     */
    private static int[] generateRandomSequence(int length) {
        // Create a set to store the numbers
        int[] sequence = new int[length];
        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        // Generate random numbers and add them to the set
        int index = 0;
        while (index < length) {
            int randomNumber = random.nextInt(20) + 1;
            if (!set.contains(randomNumber)) {
                sequence[index++] = randomNumber;
                set.add(randomNumber);
            }
        }
        return sequence;
    }

    /**
     * Creates a graph from a sequence of numbers
     * @param sequence the sequence of numbers
     * @return the graph
     */
    private static Graph createGraph(int[] sequence) {
        // Create a graph with the same number of vertices as the sequence
        Graph graph = new Graph(sequence.length);

        // Add the vertices to the graph
        for (int i = 0; i < sequence.length; i++) {
            graph.addVertex(String.valueOf(sequence[i]));
        }

        // Add the edges to the graph
        for (int i = 0; i < sequence.length; i++) {
            // Add an edge from the current vertex to all vertices with a greater value
            for (int j = i + 1; j < sequence.length; j++) {
                // If the value of the current vertex is less than the value of the next vertex, add an edge
                if (sequence[j] > sequence[i]) {
                    graph.addEdge(String.valueOf(sequence[i]), String.valueOf(sequence[j]));
                }
            }
        }
        return graph;
    }

    /**
     * Finds the longest increasing subsequence in a sequence of numbers using dynamic programming
     * @param sequence the sequence of numbers
     * @return the length of the longest increasing subsequence
     */
    private static int findLIS(int[] sequence) {
        // Create an array to store the length of the longest increasing subsequence ending at each index
        int[] dp = new int[sequence.length];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        //for each index, check all previous indices
        for (int i = 1; i < sequence.length; i++) {
            //for each previous index, check if the value is less than the current value
            for (int j = 0; j < i; j++) {
                //if the value is less than the current value and the length of the LIS ending at the previous index is greater than the current LIS, update the LIS
                if (sequence[i] > sequence[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }
        return maxLIS;
    }

    /**
     * Writes the output to a file
     * @param longestPathGraph the length of the longest increasing subsequence found using DFS
     * @param lisDP the length of the longest increasing subsequence found using dynamic programming
     * @param sequence the sequence of numbers
     */
    private static void writeOutput(int longestPathGraph, int lisDP, String sequence) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Sequence: " + sequence + "\n");
            writer.write("Graph: Longest increasing subsequence is " + longestPathGraph + "\n");
            writer.write("DP: Length of longest increasing subsequence is " + lisDP + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
