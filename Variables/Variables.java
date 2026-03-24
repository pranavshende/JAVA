package Variables;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 📘 TOPIC 1: VARIABLES
 * A complete practice and revision module from basics to advanced.
 * Covers core concepts, scope, defaults, static rules, shadowing, multithreading, and more.
 */
public class Variables {

    // =========================================================================
    // SECTION 1: BASICS - Types of Variables
    // =========================================================================

    // 1. Instance Variables (Non-Static Fields)
    // Declared inside a class but outside any method.
    // Memory: Allocated on the Heap when the object is instantiated.
    // Lifecycle: Exists as long as the object exists.
    int instanceVariable = 10;
    
    // 2. Static Variables (Class Variables)
    // Declared with the 'static' keyword.
    // Memory: Allocated in the Method Area / Metaspace once when the class is loaded.
    // Lifecycle: Exists for the lifetime of the application.
    // Q: Why are static variables considered part of the class definition?
    // A: They belong to the class as a whole, shared among all instances, rather than bound to a specific object state.
    static int staticVariable = 20;

    // 3. Final Variables (Constants)
    // Q: You need a variable whose value must never change after initialization. Which type?
    // A: A 'final' variable. Once initialized, it cannot be reassigned. Good for immutability.
    final int MAX_USERS = 100;
    
    // =========================================================================
    // SECTION 2: DEFAULT VALUES
    // =========================================================================

    // Q: How does Java handle default values for instance and local variables?
    // Instance and static variables get default values if not explicitly initialized.
    int defaultInt;       // defaults to 0
    boolean defaultBool;  // defaults to false
    String defaultString; // defaults to null

    public void demonstrateLocalVariables() {
        // 4. Local Variables
        // Declared within a method, constructor, or block.
        // Memory: Stored on the Thread Stack.
        // Lifecycle: Created when entering the method/block, popped off when exiting.
        
        int localVariable; 
        
        // System.out.println(localVariable); // COMPILE ERROR: Local variables have NO default values!
        // They must be explicitly initialized before use.
        localVariable = 30;
        System.out.println("Local initialized: " + localVariable);
        
        // Q: How does variable scope impact memory allocation and lifecycle?
        // A: Tighter scope (local variables) means memory is reclaimed instantly when the 
        // block finishes (popped from stack), avoiding garbage collection overhead on the Heap.
    }

    // =========================================================================
    // SECTION 3: SHADOWING
    // =========================================================================

    // Q: What is shadowing in Java?
    // A: It occurs when a local variable or parameter has the same name as an instance variable,
    // effectively hiding the instance variable within that scope.
    public void demonstrateShadowing(int instanceVariable) {
        System.out.println("--- Shadowing Example ---");
        System.out.println("Shadowed local value: " + instanceVariable);
        // To access the shadowed instance variable, we use the 'this' keyword:
        System.out.println("Instance value via 'this': " + this.instanceVariable);
    }

    // =========================================================================
    // SECTION 4: EDGE CASES & COMMON MISTAKES
    // =========================================================================

    // Q: A developer declares a loop variable outside the loop... What went wrong?
    public void variableScopePitfall() {
        // BAD PRACTICE: Declaring 'i' outside the loop pollutes the method's scope.
        int i;
        for (i = 0; i < 5; i++) {
            // processing
        }
        System.out.println("Leaked variable 'i' survives the loop: " + i);
        // If 'i' is reused later without resetting, it will cause unexpected logical bugs!

        // GOOD PRACTICE: Tightly scope the variable.
        for (int j = 0; j < 5; j++) {
            // 'j' dies at the end of this block.
        }
    }

    // =========================================================================
    // SECTION 5: ADVANCED & MULTITHREADING ISSUES
    // =========================================================================

    // Q: Static counter in production showing duplicate values across threads. Why? 
    // A: 'counter++' is not an atomic operation. It is Read -> Modify -> Write.
    // Threads interleave, read stale values, and overwrite each other's updates.
    static int unsafeCounter = 0; 
    
    // FIX 1: Use synchronized blocks/methods.
    // FIX 2: Use Atomic variables for thread-safe lock-free operations.
    static AtomicInteger safeCounter = new AtomicInteger(0);

    public static void incrementCounters() {
        unsafeCounter++;
        safeCounter.incrementAndGet();
    }

    // Q: User-specific data is stored in a static variable accidentally. Security issues?
    // A: Major security leak! Static variables are shared globally across ALL threads. 
    // User A's thread might overwrite the static variable, and User B's thread reads User A's private data.
    static String globalUserSession; // DANGEROUS IN WEB APPS!

    // FIX: Use ThreadLocal for thread-specific state.
    static final ThreadLocal<String> secureUserSession = new ThreadLocal<>();

    // =========================================================================
    // SECTION 6: MEMORY OPTIMIZATION & REFACTORING
    // =========================================================================

    // Q: Class has many instance variables causing object memory footprint to increase. How to refactor?
    // BAD: 
    // String street; String city; String zipCode; String state; String country;
    
    // GOOD: Use Composition (Extracting fields into a separate reusable object)
    // This improves cohesion and makes the object smaller (especially if shared).
    Address address;

    static class Address {
        String street, city, zipCode, state, country;
    }
}