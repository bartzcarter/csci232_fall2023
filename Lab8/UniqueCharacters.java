/**
 * Problem: Implement an algorithm to determine if a string has all unique characters using hashing
 * use boolean array to store the characters that have been encountered
 * @author Carter Bartz
 * @version 1.0
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UniqueCharacters{

    /**
     * Determines if a string has all unique characters
     * @param word
     * @return true if all characters are unique, false otherwise
     */
    public static boolean allUnique(String word) {
        // If the string is longer than the number of unique characters, not all characters are unique
        boolean[] charSet = new boolean[128];

        // Iterate through the string
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If the character is encountered again, return false
            if (charSet[ch]) {
                return false;
            }
            // Mark the character as encountered
            charSet[ch] = true;
        }
        // All characters are unique
        return true;
    }

    /**
     * Returns a string of all unique characters in the given string
     * @param word
     * @return string of unique characters
     */
    public static String uniqueChars(String word) {
        boolean[] charSet = new boolean[128];
        boolean[] repeatedSet = new boolean[128];
        StringBuilder uniqueChars = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If the character is not encountered, mark it as encountered
            if (!charSet[ch]) {
                charSet[ch] = true;
            } 
            else {
                // If the character is encountered again, mark it as repeated
                repeatedSet[ch] = true;
            }
        }
        // Build the result string with characters that appear only once
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If the character is encountered and not repeated, add it to the result string
            if (charSet[ch] && !repeatedSet[ch]) {
                uniqueChars.append(ch);
            }
        }
        return uniqueChars.toString();
    }

    public static void main(String[] args) {
        // Read strings from the file and determine if they have all unique characters
        try (Scanner scanner = new Scanner(new File("inhash.txt"))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                System.out.println("Is string " + word + " unique? " + allUnique(word));
                System.out.println("Unique characters are " + uniqueChars(word));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
