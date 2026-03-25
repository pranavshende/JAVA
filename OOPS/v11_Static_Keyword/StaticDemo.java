package OOPS.v11_Static_Keyword;

/**
 * 📘 TOPIC: STATIC KEYWORD
 * 
 * 1. Static: Belong to the CLASS, NOT to any object instance.
 * 2. Static Variables: Shared across all objects (Memory Management).
 * 3. Static Methods: Can be called without creating an object.
 * 4. Static Blocks: Executed BEFORE the main method (During Class Loading).
 * 5. Static Classes: Nested static classes (Can only access static members).
 */

class Counter {
    // [1] BASIC: static vs non-static field
    static int count = 0; // Shared across all objects
    int instanceId = 0; // Unique to each object

    Counter() {
        count++;
        instanceId++;
        System.out.println("Counter instance created (ID: " + instanceId + ")");
    }

    // [2] INTERMEDIATE: static method
    // Cannot access 'instanceId' here!
    static void displayCount() {
        // System.out.println("ID: " + instanceId); // COMPILE ERROR: Cannot access non-static from static context!
        System.out.println("Current Shared Count: " + count);
    }
}

/**
 * [3] ADVANCED: static block
 * 
 * Static block is executed when the class is LOADED into JVM.
 * This is useful for initializing static data or libraries.
 */
class Logger {
    static String logFileSuffix;

    static {
        System.out.println("Static Block Executed: Initializing logFileSuffix...");
        logFileSuffix = "_LOG_" + System.currentTimeMillis();
    }

    static void printSuffix() {
        System.out.println("Log suffix: " + logFileSuffix);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("--- Static Field Example ---");
        @SuppressWarnings("unused") Counter c1 = new Counter();
        @SuppressWarnings("unused") Counter c2 = new Counter();
        @SuppressWarnings("unused") Counter c3 = new Counter();

        // [4] INTERVIEW FOCUS:
        // Shared count is 3, while individual instanceId is 1 for ALL objects.
        Counter.displayCount(); 
        
        System.out.println("\n--- Static Block Example ---");
        // Even before we call Logger, the JVM will execute its static block.
        Logger.printSuffix();

        // [5] INCORRECT USAGE:
        // System.out.println(Counter.instanceId); // COMPILE ERROR: Cannot access instance field via class name!

        // [6] EDGE CASE:
        // "Why main() is static?"
        // Because the JVM needs to call main() without creating an object of the class!
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Static):
 * 1. When Counter is used, JVM allocates memory for 'count' once in Method Area.
 * 2. Each new Counter() increments 'count'.
 * 3. Each new Counter() only increments its OWN 'instanceId' in Heap Area.
 * 4. Thus, count = 3, instanceId = 1.
 */
