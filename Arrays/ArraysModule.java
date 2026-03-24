package Arrays;

import java.util.Arrays;

/**
 * 📘 TOPIC: ARRAYS
 * Large practice module for statically-sized indexed storage.
 * Covers memory allocation, multi-dimensional grids, utilities, and interview algorithms.
 */
public class ArraysModule {

    // =========================================================================
    // SECTION 1: BASICS - Declaration & Memory
    // =========================================================================

    public void demonstrateBasics() {
        // Q: How are arrays stored in memory?
        // A: Arrays are Objects on the HEAP. Elements are stored in contiguous memory blocks.
        // Once created, the size is FIXED and cannot be changed.
        
        int[] fixedArray = {10, 20, 30, 40, 50}; // Initialized with values

        System.out.println("Array length: " + fixedArray.length);
        System.out.println("First element (index 0): " + fixedArray[0]);
    }

    // =========================================================================
    // SECTION 2: COMMON ALGORITHMS (Interview Based)
    // =========================================================================

    // Q: Find the largest element in an array efficiently.
    public void findLargest(int[] array) {
        if (array == null || array.length == 0) return;
        
        int max = array[0]; // Assume first is largest
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Largest element: " + max);
    }

    // Q: Reverse an array in-place (Space complexity O(1)).
    public void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // =========================================================================
    // SECTION 3: MULTI-DIMENSIONAL ARRAYS (Matrices)
    // =========================================================================

    public void matrixDemonstration() {
        // Q: How are 2D arrays represented in Java memory?
        // A: "Array of Arrays". Each row is its own object on the Heap.
        int[][] matrix = { {1, 2}, {3, 4} };
        System.out.println("Matrix element [1][0]: " + matrix[1][0]);

        // Q: What is a Jagged Array?
        // A: An array of arrays where rows have different lengths.
        int[][] jagged = new int[2][];
        jagged[0] = new int[3]; 
        jagged[1] = new int[5];
    }

    // =========================================================================
    // SECTION 4: JAVA ARRAYS UTILITY CLASS (Best Practices)
    // =========================================================================

    public void utilityMethods() {
        int[] numbers = {5, 2, 9, 1, 3, 20}; // Renamed 'data' to 'numbers' and added 20
        
        // 1. Sorting (Dual-Pivot Quicksort O(N log N))
        Arrays.sort(numbers); 
        
        // 2. Searching (Must be sorted first!)
        int index = Arrays.binarySearch(numbers, 20);
        System.out.println("Index of 20: " + index);
        
        // 3. Printing (Don't use toString(), use Arrays.toString())
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 5, 9, 20]

        // 4. Copying (Deep copying vs reference copy)
        int[] copy = Arrays.copyOf(numbers, 5);
        System.out.println("Copy length: " + copy.length);
    }

    // =========================================================================
    // SECTION 5: PERFORMANCE & PITFALLS
    // =========================================================================

    // Q: ArrayIndexOutOfBoundsException - Why does it happen?
    // A: Accessing index < 0 or index >= length. Java checks bounds at RUNTIME.
    
    // Q: Multithreading issues?
    // A: Arrays are NOT synchronized. If one thread iterates while another modifies at the same index,
    // data corruption occurs. 
    
    // Performance: Iterating rows-first (matrix[i][j]) is cache-friendly compared to columns-first 
    // because elements are stored contiguously within the row.

    public static void main(String[] args) {
        System.out.println("Arrays module initialized.");
    }
}
