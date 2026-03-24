package Methods;

/**
 * 📘 TOPIC 10: METHODS & RECURSION
 * Reusable blocks of code and self-referential logic.
 * Covers Varargs, Recursion, and Method Overloading.
 */
public class MethodsModule {

    // =========================================================================
    // SECTION 1: VARARGS (Variable Arguments)
    // =========================================================================

    // Q: What is Varargs?
    // A: A method that can accept zero or more arguments of a specific type.
    // It's treated internally as an array.
    public int sumVarargs(int... numbers) {
        System.out.println("--- 1. Varargs ---");
        int sum = 0;
        for (int n : numbers) sum += n;
        return sum;
        
        // Example: sumVarargs(1, 2, 3) or sumVarargs(10, 20)
    }

    // =========================================================================
    // SECTION 2: STATIC VS INSTANCE METHODS
    // =========================================================================

    // Q: Why can't a static method call a non-static member?
    // A: Static methods belong to the class definition and exist BEFORE 
    // any object is created. A non-static member belongs to a SPECIFIC object.
    
    // Static Method
    public static void staticInfo() {
        System.out.println("No object needed to call me.");
    }

    // Instance Method
    public void instanceInfo() {
        System.out.println("Object is required to call me.");
    }

    // =========================================================================
    // SECTION 3: RECURSION (Self-Calling)
    // =========================================================================

    // Q: What is Recursion?
    // A: A method calling itself until it reaches a "Base Case".
    // DANGER: Without a Base Case, recursion causes a StackOverflowError.
    
    /**
     * Classic Interview Problem: Factorial of N
     * n! = n * (n-1) * (n-2)... * 1
     */
    public int factorial(int n) {
        System.out.println("Calculating factorial for n: " + n);
        
        // Base Case (Prevention of StackOverflow)
        if (n <= 1) return 1;

        // Recursive Step
        return n * factorial(n - 1);
    }

    /**
     * Classic Interview Problem: Fibonacci series at index N
     * sequence: 0, 1, 1, 2, 3, 5, 8...
     */
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // =========================================================================
    // SECTION 4: STACK OVERFLOW & PERFORMANCE
    // =========================================================================

    /*
     * Q: Why is Recursion often slower than Looping?
     * A: Each recursive call adds a new "Frame" to the Thread Stack. 
     *    This consumes memory and adds execution overhead (push/pop).
     * 
     * PERF TIP: Use Iteration (Loops) for simple counting tasks. 
     * Use Recursion for tree/graph traversal or divide-and-conquer problems (QuickSort).
     */

    // =========================================================================
    // SECTION 5: METHOD OVERLOADING (Refresher)
    // =========================================================================

    // Overloading: Same name, different parameters.
    public void printInfo(String msg) { System.out.println("MSG: " + msg); }
    public void printInfo(int num) { System.out.println("NUM: " + num); }
}
