package Generics;

import java.util.List;

/**
 * 📘 TOPIC 9: GENERICS
 * Enabling types (classes and interfaces) to be parameters.
 * Covers Safe Collections, Wildcards, and Type Erasure.
 */
public class GenericsModule {

    // =========================================================================
    // SECTION 1: BASICS - Generic Classes & Methods
    // =========================================================================

    // Q: What is the benefit of Generics?
    // A: 1. Compile-time type safety (Catching errors early).
    // A: 2. Elimination of casting.
    // A: 3. Code reusability (Single class for String, Integer, etc).
    
    // Generic Class definition: <T> is the Type Parameter.
    static class Box<T> {
        private T content;

        public Box(T content) { this.content = content; }

        public T getContent() { return content; }
    }

    public void demonstrateGenericClass() {
        System.out.println("--- 1. Generic Class ---");
        
        // Specifying String as the type
        Box<String> stringBox = new Box<>("Hello Generics!");
        System.out.println("String Box: " + stringBox.getContent());

        // Specifying Integer as the type
        Box<Integer> integerBox = new Box<>(123);
        System.out.println("Integer Box: " + integerBox.getContent());
    }

    // =========================================================================
    // SECTION 2: GENERIC METHODS
    // =========================================================================

    // Q: How to write a method that accepts a generic array and prints it?
    public static <E> void printArray(E[] elements) {
        System.out.println("--- 2. Generic Method ---");
        for (E element : elements) {
            System.out.println("Elem: " + element);
        }
    }

    // =========================================================================
    // SECTION 3: WILDCARDS (Upper Bound & Lower Bound)
    // =========================================================================

    // Q: What is a Wildcard?
    // A: '?' refers to an "unknown type".
    
    // 1. Unbounded Wildcard: List<?> matches any List.
    public void printList(List<?> list) { 
        System.out.println("--- 3. Unbounded Wildcard ---");
        System.out.println("Size: " + list.size());
    }

    // 2. Upper Bounded Wildcard: ? extends Number
    // A: Accepts List of Number OR any of its subclasses (Integer, Double, etc).
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) s += n.doubleValue();
        return s;
    }

    // 3. Lower Bounded Wildcard: ? super Integer
    // A: Accepts List of Integer OR any of its superclasses (Number, Object).
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    // =========================================================================
    // SECTION 4: TYPE ERASURE (Interview Hot-Topic)
    // =========================================================================

    /*
     * Q: What is Type Erasure?
     * A: Generics are processed at COMPILE-TIME only. The JVM does NOT know 
     *    anything about them. The compiler "erases" the generic types and 
     *    replaces them with 'Object' (or the bound) to ensure backwards 
     *    compatibility with older versions of Java.
     * 
     * RESULT: 
     * List<String> and List<Integer> are the SAME class at runtime! 
     * You cannot overload methods using just generic type differences.
     */

    // =========================================================================
    // SECTION 5: RESTRICTIONS ON GENERICS
    // =========================================================================

    /*
     * 1. Cannot instantiate Generic Types with Primitives (use Wrappers).
     * 2. Cannot create instances of Type Parameters: new T(). (Use Reflection).
     * 3. Cannot create Static fields of Type Parameters.
     * 4. Cannot create Arrays of Generic Types: new T[10].
     */
}
