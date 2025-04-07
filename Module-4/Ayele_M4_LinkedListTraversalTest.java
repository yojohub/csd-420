

/* 
 *  Name: Yohannes Ayele
 *  Date: 04/06/25
 *  Assignment: M4: Ayele_M4_LinkedListTraversalTest
 *  Purpose of the code: Test the time to traverse the list using an iterator vs. using the get(index) method.
 *  Gethub: https://github.com/yojohub/csd-420.git
 */


 import java.util.Iterator;
 import java.util.LinkedList;
 
 public class Ayele_M4_LinkedListTraversalTest {
 
     public static void main(String[] args) {
         // Test Traversal Performance with 50,000 integers
         System.out.println("Performance test for the 50,000 elements:");
         TraversalPerformance(50000);
 
         // Test Traversal Performance with 500,000 integers
         System.out.println("\nPerformance test for the 500,000 elements:");
         TraversalPerformance(500000);
     }
 
     public static void TraversalPerformance(int size) {
         // Create LinkedList and add integers
         LinkedList<Integer> list = new LinkedList<>();
         for (int i = 0; i < size; i++) {
             list.add(i);
         }
 
         // Traverse using Iterator
         long startTime = System.currentTimeMillis();
         Iterator<Integer> iterator = list.iterator();
         while (iterator.hasNext()) {
             iterator.next(); // Traverse only
         }
         long endTime = System.currentTimeMillis();
         long iteratorTime = endTime - startTime;
         System.out.println("Time for Iterator traversal: " + iteratorTime + " ms");
 
         // Traverse using get(index)
         startTime = System.currentTimeMillis();
         for (int i = 0; i < list.size(); i++) {
             list.get(i); // Access each element by index
         }
         endTime = System.currentTimeMillis();
         long getTime = endTime - startTime;
         System.out.println("Time for get(index) traversal: " + getTime + " ms");

         // Summary comment
         System.out.println("In summary, get(index) on LinkedList is much slower than iterator, especially when the list size grows.");
     }
 }
 