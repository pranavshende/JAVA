package Loops;

import java.util.List;

/**
 * 📘 TOPIC: LOOPS & ITERATION
 * Essential control flow for repetitive tasks.
 * Covers for, while, do-while, and the enhanced for-loop.
 */
public class LoopsModule {

    // =========================================================================
    // SECTION 1: FOR LOOP (Counter-based)
    // =========================================================================

    public void demonstrateForLoop() {
        // Q: Basic syntax of for loop?
        // A: initialization; condition; increment/decrement
        System.out.println("--- Standard For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // =========================================================================
    // SECTION 2: WHILE & DO-WHILE (Condition-based)
    // =========================================================================

    public void demonstrateWhileLoops() {
        // Q: Difference between while and do-while?
        // A: 'while' checks condition FIRST. 'do-while' executes ONCE, then checks.
        
        int count = 10;
        
        System.out.println("--- While Loop (Pre-check) ---");
        while (count < 5) { // Never runs
            System.out.println("This won't print.");
        }

        System.out.println("--- Do-While Loop (Post-check) ---");
        do {
            System.out.println("Executes at least once! Count is: " + count);
        } while (count < 5);
    }

    // =========================================================================
    // SECTION 3: ENHANCED FOR LOOP (For-Each)
    // =========================================================================

    // Q: When to use for-each over standard for?
    // A: Use for-each when you don't need the index. It is cleaner and prevents index bugs.
    public void demonstrateForEach(List<String> items) {
        System.out.println("--- Enhanced For Loop ---");
        for (String item : items) {
            System.out.println("Processing: " + item);
        }
    }

    // =========================================================================
    // SECTION 4: BREAK & CONTINUE (Flow Control)
    // =========================================================================

    // Q: Difference between break and continue?
    // A: 'break' exits the entire loop. 'continue' skips current iteration and goes to next.
    public void breakAndContinue() {
        System.out.println("--- Break vs Continue ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 3) continue; // Skip 3
            if (i == 6) break;    // Exit at 6
            System.out.print(i + " "); 
        }
        // Output: 1 2 4 5
        System.out.println();
    }

    // =========================================================================
    // SECTION 5: INFINITE LOOPS & PERFORMANCE
    // =========================================================================

    /*
     * Q: Most common cause of high CPU usage in Java apps?
     * A: Infinite loops or loops processing massive data on the Main Thread.
     * 
     * PERF TIP: Avoid creating objects inside a tight loop! 
     * BAD: for(...) { String s = new String("test"); } 
     * GOOD: String s = "test"; for(...) { // use s }
     */
    
    // =========================================================================
    // SECTION 6: NESTED LOOPS & INTERVIEW PROBLEM
    // =========================================================================

    // Q: Print a 2D pattern (Interview Classic)
    public void printStarPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
