
/* 
 *  Name: Yohannes Ayele
 *  Date: 03/30/25
 *  Assignment: M2: Programing Assignment write Data file 
 *  Purpose of the code: This program writes five random integers and double numbers into data into a filename.
 *  Gethub: https://github.com/yojohub/csd-420.git
 */


import java.io.*;
import java.util.Random;

public class Ayele_M2_Assignment_WriteDataFile {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\joyay\\csd\\csd-420\\Module-2\\Ayele_Datafile.dat";
        Random rand = new Random();

        try {
            // Create a File object
            File file = new File(fileName);
            boolean isNewFile = file.createNewFile(); // Creates the file if it doesn't exist

            // Open the file in append mode
            try (FileWriter fw = new FileWriter(file, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter pw = new PrintWriter(bw)) {

                // If it's a new file, add a header for clarity
                if (isNewFile) {
                    pw.println("===== Data File Created =====");
                }

                // Generate five random double numbers and write
                pw.print("List of Double Numbers: ");
                for (int i = 0; i < 5; i++) {
                    pw.print(rand.nextDouble() * 50 + " "); // Random doubles (0-50)
                }
                pw.println(); 

                // Generate five random integers and write
                pw.print("List of Integer Numbers: ");
                for (int i = 0; i < 5; i++) {
                    pw.print(rand.nextInt(50) + " "); // Random integers (0-49)
                }
                pw.println(); 

                System.out.println(isNewFile ? "File created and data written." : "Data appended to existing file.");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
