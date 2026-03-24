package Vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * 📘 TOPIC: THE VECTOR CLASS
 * Exploring the legacy thread-safe dynamic array.
 * Covers Vector vs. ArrayList, synchronization, and capacities.
 */
public class VectorModule {

    // =========================================================================
    // SECTION 1: BASICS - Operations
    // =========================================================================

    public void demonstrateVector() {
        // Q: What is Vector?
        // A: A dynamic array that is part of the legacy Collections API (Java 1.0).
        // It implements List, making it similar to ArrayList.
        Vector<String> list = new Vector<>();
        
        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println("Vector Content: " + list);
        System.out.println("Vector Size: " + list.size());
    }

    // =========================================================================
    // SECTION 2: THE INTERVIEW TRAP - Vector vs. ArrayList
    // =========================================================================

    /*
     * Q: Vector vs. ArrayList - Which to use?
     * 1. Synchronization: Vector is THREAD-SAFE (synchronized). ArrayList is not.
     * 2. Performance: ArrayList is FASTER because it doesn't have synchronization overhead.
     * 3. Growth: Vector doubles its size (100% increase), ArrayList grows by 50%.
     * 4. Legacy: Vector is considered a legacy class. 
     * 
     * BEST PRACTICE: Prefer ArrayList. For thread-safety, use:
     * Collections.synchronizedList(new ArrayList<>());
     * OR CopyOnWriteArrayList for multi-thread reads.
     */

    // =========================================================================
    // SECTION 3: ITERATION (Enumeration vs. Iterator)
    // =========================================================================

    public void iterationModes(Vector<Integer> v) {
        // 1. Enumeration (Legacy - Only available in Vector/Hashtable)
        Enumeration<Integer> e = v.elements();
        while (e.hasMoreElements()) {
             System.out.println(e.nextElement());
        }

        // 2. Iterator (Modern - Fail-fast)
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
             System.out.println(it.next());
        }
    }

    // =========================================================================
    // SECTION 4: CAPACITY vs. SIZE
    // =========================================================================

    public void capacityCheck() {
        // Q: Capacity vs. Size?
        // A: Size is the number of elements current in the Vector.
        // A: Capacity is the total space allocated (allocated blocks).
        Vector<Integer> v = new Vector<>(5, 10); // Initial capacity 5, increment 10
        System.out.println("Initial Capacity: " + v.capacity()); // 5
        
        for (int i = 0; i < 6; i++) v.add(i);
        
        System.out.println("New Capacity: " + v.capacity()); // 15 (Initial 5 + increment 10)
    }

    // =========================================================================
    // SECTION 5: STACK EXAMPLE (Inheritance)
    // =========================================================================

    /*
     * Q: Why is the Stack class considered poorly designed in Java?
     * A: 'java.util.Stack' EXTENDS 'Vector'. This means Stack inherits random-access 
     * methods (get, remove) which violates the LIFO principle.
     * 
     * BEST PRACTICE: Use 'Deque<Integer> stack = new ArrayDeque<>();'
     */
}
