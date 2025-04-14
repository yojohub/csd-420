

/* 
 *  Name: Yohannes Ayele
 *  Date: 04/13/25
 *  Assignment: MS: Ayele_M5_UniqueWords
 *  Purpose of the code: A test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.
 *  Gethub: https://github.com/yojohub/csd-420.git
 */

 import java.io.File;
import java.io.IOException;
import java.util.*;

public class Ayele_M5_UniqueWords {

    public static void main(String[] args) {
        String filename = "C:\\Users\\joyay\\csd\\csd-420\\Module-5\\collection_of_words.txt";

        // TreeSet automatically removes duplicates and sorts the words
        Set<String> uniqueWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                String word = cleanWord(fileScanner.next());
                if (!word.isEmpty()) {
                    uniqueWords.add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read the file: " + e.getMessage());
            return;
        }

        if (uniqueWords.isEmpty()) {
            System.out.println("No words found in the file.");
        } else {
            displayWordsInOrder(uniqueWords, true);  // Ascending
            displayWordsInOrder(uniqueWords, false); // Descending

            runBasicTest(uniqueWords);
        }
    }

    // Below code will cleans each word by removing punctuation and converting to lowercase
    private static String cleanWord(String word) {
        return word.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    // Display words in ascending or descending order
    public static void displayWordsInOrder(Set<String> words, boolean ascending) {
        System.out.println("\nWords in " + (ascending ? "Ascending" : "Descending") + " Order:");
        List<String> wordList = new ArrayList<>(words);
        if (!ascending) {
            Collections.reverse(wordList);
        }
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    // This is a basic test to verify a known word exists
    public static void runBasicTest(Set<String> wordSet) {
        System.out.println("\nRunning basic test...");
        String testWord = "john";
        if (wordSet.contains(testWord)) {
            System.out.println("Test passed: '" + testWord + "' found in uniqueWords set.");
        } else {
            System.out.println("Test failed: '" + testWord + "' not found in uniqueWords set.");
        }
    }
}
