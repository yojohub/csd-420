

/* 
 *  Name: Yohannes Ayele
 *  Date: 04/06/25
 *  Assignment: M3: Generic method to remove duplicates from an ArrayList
 *  Purpose of the code: Generate random numbers and remove duplicates from an ArrayList
 *  Gethub: https://github.com/yojohub/csd-420.git
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Ayele_M3_Assignment_RemoveDuplicates {
        // Generic method to remove duplicates from an ArrayList
     public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Use a HashSet to eliminate duplicates and return a new ArrayList
        HashSet<E> set = new HashSet<>(list);
         return new ArrayList<>(set);
    }   
    public static void main(String[] args) {
        // Create an ArrayList to hold random numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Generate the list with 50 random numbers between 1 and 20
        for (int i = 0; i < 50; i++) {
            int randomNum = random.nextInt(20) + 1;
            numbers.add(randomNum);
        }

        // Display the original ArrayList with duplicates values
        System.out.println("Display original ArryList with duplicates: " + numbers);
        
        // Remove duplicates from the list
        ArrayList<Integer> uniqueNum = removeDuplicates(numbers);

        // Display the ArrayList without duplicates values
        System.out.println("Display ArrayList after removing duplicates: " + uniqueNum);
    }

 
    
}
