

/* 
 *  Name: Yohannes Ayele
 *  Date: 03/30/25
 *  Assignment: M2: Programing Assignment read Data from file and displays
 *  Purpose of the code: This program reads Data from files and displays the results
 *  Gethub: https://github.com/yojohub/csd-420.git
 */

import java.io.*;

public class Ayele_M2_Assignment_DataRead {
    public static void main(String[] args) {
        // Below is the file name to be read
        String fileName = "C:\\Users\\joyay\\csd\\csd-420\\Module-2\\Ayele_Datafile.dat";

        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line; 
            
            // Read the file line by line until the end is reached
            while ((line = br.readLine()) != null) {
                // Print each line to the console
                System.out.println(line);
            }
        } catch (IOException e) { // Catch block to handle file I/O exceptions
            // Print an error message 
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}