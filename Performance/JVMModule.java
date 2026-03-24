package Performance;

/**
 * 📘 TOPIC 14: JVM & MEMORY MANAGEMENT
 * Understanding how Java runs and how garbage is collected.
 * Covers Memory Model, Garbage Collection, and Optimization.
 */
public class JVMModule {

    // =========================================================================
    // SECTION 1: JVM MEMORY MODEL (Runtime Data Areas)
    // =========================================================================

    /*
     * 1. Method Area / Metaspace: Stores class definitions, static variables, 
     *    and constant pool. (Shared).
     * 2. Heap Area: Stores all Objects and Arrays. (Shared).
     * 3. Thread Stack: Stores local variables, method call frames. (Thread-local).
     * 4. Program Counter (PC) Register: Stores next instruction address. (Thread-local).
     * 5. Native Method Stack: For native (C/C++) methods. (Thread-local).
     */

    // =========================================================================
    // SECTION 2: THE HEAP DIVISIONS (Generational Hypothesis)
    // =========================================================================

    /*
     * Q: Why is the Heap divided into Young and Old Generations?
     * A: Hypothesis: "Most objects die young".
     * 
     * 1. Young Generation (Minor GC):
     *    - Eden Space: New objects are born here.
     *    - Survivor Spaces (S0, S1): Objects that survive Minor GC move here.
     * 
     * 2. Old Generation (Major/Full GC):
     *    - Tenured Space: Objects that survived multiple GCs move here.
     *    - Full GC is much SLOWER than Minor GC (it pauses the entire application).
     */

    // =========================================================================
    // SECTION 3: GARBAGE COLLECTION ALGORITHMS
    // =========================================================================

    /*
     * 1. Serial GC: Single-threaded. For small apps.
     * 2. Parallel GC: Multi-threaded (throughput-oriented).
     * 3. G1 GC (Garbage First): Breaks heap into small regions. (Default in Java 9+).
     * 4. ZGC (Z Garbage Collector): Ultra-low latency (pauses < 1ms). (Java 15+).
     */

    // =========================================================================
    // SECTION 4: OUT OF MEMORY ERRORS (OOME)
    // =========================================================================

    /*
     * Q: Common OOME causes?
     * 1. java.lang.OutOfMemoryError: Java heap space. 
     *    (FIX: Increase -Xmx, or optimize object creation).
     * 2. java.lang.StackOverflowError: Recursion depth too high.
     * 3. java.lang.OutOfMemoryError: Metaspace. 
     *    (Too many classes loaded dynamically - Reflection/Libraries).
     */

    public void demonstrateGCRequest() {
        System.out.println("--- 4. Requesting GC ---");
        // Q: Can you force Garbage Collection?
        // A: NO. System.gc() only requests the JVM to run it. JVM may ignore it!
        System.gc(); // Only a suggestion.
    }

    // =========================================================================
    // SECTION 5: INTERVIEW KEYWORDS - Stop-the-World
    // =========================================================================

    /*
     * Q: What is a "Stop-the-World" (STW) event?
     * A: A moment where the JVM pauses ALL application threads to perform GC safely.
     *    Goal of modern GCs (like G1, ZGC) is to minimize these STW pauses.
     * 
     * Q: How to check GC logs?
     * A: Use JVM flag: -Xlog:gc*
     */
}
