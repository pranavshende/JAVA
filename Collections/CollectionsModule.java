package Collections;

import java.util.*;

/**
 * 📘 TOPIC 4: COLLECTIONS FRAMEWORK
 * A comprehensive guide to managing groups of objects.
 * Covers List, Set, Map, and the essential differences.
 */
public class CollectionsModule {

    // =========================================================================
    // SECTION 1: LIST INTERFACE (Ordered, Allows Duplicates)
    // =========================================================================

    public void demonstrateList() {
        // Q: ArrayList vs LinkedList?
        /*
         * ArrayList: Fast for Search/Retrieval (O(1) with index). Use if reads are common.
         * LinkedList: Fast for Add/Remove at ends (O(1)). Use if insertions/deletions are frequent.
         */
        System.out.println("--- 1. List Interface ---");
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Duplicates allowed

        System.out.println("ArrayList Content: " + fruits);
        System.out.println("Element at 1: " + fruits.get(1));
    }

    // =========================================================================
    // SECTION 2: SET INTERFACE (Unordered, Unique Elements)
    // =========================================================================

    public void demonstrateSet() {
        // Q: HashSet vs TreeSet?
        /*
         * HashSet: O(1) performance. Unordered. (Uses HashMap internally).
         * LinkedHashSet: Maintains insertion order.
         * TreeSet: SORTED order (Natural or via Comparator).
         */
        System.out.println("--- 2. Set Interface ---");
        Set<Integer> uniqueNums = new HashSet<>();
        uniqueNums.add(10);
        uniqueNums.add(20);
        uniqueNums.add(10); // Duplicate IGNORED

        System.out.println("HashSet Content: " + uniqueNums);
        
        // Example: Removing duplicates from a list
        List<Integer> listWithDupes = Arrays.asList(1, 2, 2, 3, 3, 3);
        Set<Integer> uniqueSet = new HashSet<>(listWithDupes);
        System.out.println("Cleaned List: " + uniqueSet);
    }

    // =========================================================================
    // SECTION 3: MAP INTERFACE (Key-Value Pairs)
    // =========================================================================

    public void demonstrateMap() {
        // Q: HashMap vs Hashtable?
        /*
         * HashMap: FAST. Allows one NULL key. NOT thread-safe. (Iterated via Set of keys).
         * Hashtable: LEGACY. Thread-safe but slow. No nulls.
         * TreeMap: SORTED by keys.
         */
        System.out.println("--- 3. Map Interface ---");
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(101, "Charlie"); // Q: Overwrites the previous value? A: YES.

        System.out.println("Employee 101: " + employeeMap.get(101));

        // Iterating over a Map
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue());
        }
    }

    // =========================================================================
    // SECTION 4: ITERATOR & FAIL-FAST Behavior
    // =========================================================================

    // Q: What is an Iterator?
    // A: A cursor used to step through a collection.
    // Q: What is Fail-Fast?
    // A: Iterators throw ConcurrentModificationException if a collection is 
    // modified while iterating (unless via iterator.remove()).
    public void demonstrateIterator() {
        System.out.println("--- 4. Iterator ---");
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("B")) {
                it.remove(); // SAFE removal during iteration
            }
        }
    }

    // =========================================================================
    // SECTION 5: PERFORMANCE CHART (Interview Critical)
    // =========================================================================

    /*
     * INTERVIEW TABLE:
     * Operation | ArrayList | LinkedList | HashSet | HashMap
     * --------- | --------- | ---------- | ------- | -------
     * Add       | O(1)*     | O(1)       | O(1)    | O(1)
     * Get(index)| O(1)      | O(N)       | N/A     | N/A
     * Contains  | O(N)      | O(N)       | O(1)    | O(1)
     * Remove    | O(N)      | O(1)*      | O(1)    | O(1)
     */

    // =========================================================================
    // SECTION 6: COMPARABLE VS COMPARATOR
    // =========================================================================

    // Q: Comparable vs Comparator?
    /*
     * Comparable (Natural): Inside the object (implements compareTo).
     * Comparator (Custom): Outside the object. Used for multiple sort orders.
     */
}
