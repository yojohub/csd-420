

/* 
 *  Name: Yohannes Ayele
 *  Date: 04/20/25
 *  Assignment: MS: Ayele_M6_Bubble_Sort
 *  Purpose of the code: The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
 *  Gethub: https://github.com/yojohub/csd-420.git
 */


    import java.util.Comparator;

    public class Ayele_M6_Bubble_Sort {
    
        // Below method to sort using Comparable 
        public static <T extends Comparable<T>> void sortUsingComparable(T[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        // Interchange the elements
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        
                    }
                }
            }
        }
    
        // Below method to sort using Comparator 
        public static <T> void sortUsingComparator(T[] array, Comparator<T> comp) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (comp.compare(array[j], array[j + 1]) > 0) {
                        // Interchange the elements
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        
                    }
                }
            }
        }
    
        // Below method to print the array
        public static <T> void printArray(T[] array) {
            System.out.print("Array: ");
            for (T item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    
        // Below main method to test sorting
        public static void main(String[] args) {
            // Example 1: Sorting Integer array using Comparable
            Integer[] nums = {5, 3, 1, 4, 2, 6, 9};
            System.out.println("List of array before sorting (Comparable):");
            printArray(nums);
            sortUsingComparable(nums);
            System.out.println("List of array after sorting (Comparable):");
            printArray(nums);
    
            // Example 2: Sorting Integer array using Comparator
            Integer[] addnums = {19, 17, 16, 18, 10, 14, 11};
            System.out.println("\nList of array before sorting (Comparator):");
            printArray(addnums);
            sortUsingComparator(addnums, Integer::compareTo);
            System.out.println("List of array after sorting (Comparator):");
            printArray(addnums);
            
            
        }
    
        
    }
    