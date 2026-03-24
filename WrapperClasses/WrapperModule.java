package WrapperClasses;

/**
 * 📘 TOPIC: WRAPPER CLASSES
 * Understanding the bridge between primitives and objects.
 * Covers Autoboxing, the Integer Cache, and proper object equality.
 */
public class WrapperModule {

    // =========================================================================
    // SECTION 1: BASICS - Autoboxing & Unboxing
    // =========================================================================

    public void demonstrateBoxing() {
        int primitiveInt = 45;
        
        // Autoboxing: Primitive -> Wrapper Object
        Integer wrapperObj = primitiveInt; 
        
        // Unboxing: Wrapper Object -> Primitive
        int backToPrimitive = wrapperObj; 
        System.out.println("Back to primitive: " + backToPrimitive);

        System.out.println("Boxing/Unboxing completes successfully for: " + wrapperObj);
    }

    // =========================================================================
    // SECTION 2: THE INTERVIEW TRAP - Integer Cache
    // =========================================================================

    // Q: Comparing two Wrapper objects with '==' behavior.
    // A: Integer objects between -128 and 127 are CACHED by JVM.
    // Above this range, a new object is ALWAYS created.
    public void integerCacheBug() {
        Integer a = 100, b = 100;
        System.out.println("Within cache (-128 to 127): " + (a == b)); // Output: true

        Integer x = 500, y = 500;
        System.out.println("Outside cache: " + (x == y)); // Output: false (Different objects)
        
        // BEST PRACTICE: ALWAYS use .equals() for Wrapper comparisons.
        System.out.println("Correct comparison: " + x.equals(y)); // Output: true
    }

    // =========================================================================
    // SECTION 3: DEPRECATION & CONSTRUCTION
    // =========================================================================

    // Q: Why is 'new Integer(10)' deprecated since Java 9?
    // A: It FORCES the creation of a new object on heap, ignoring the cache.
    // A: 'Integer.valueOf(10)' is much faster because it utilizes the cache.
    public void instantiation() {
        Integer fast = Integer.valueOf(10); // Efficient
        System.out.println("Efficient instantiation: " + fast);
        // Integer slow = new Integer(10); // Deprecated - Do not use!
    }

    // =========================================================================
    // SECTION 4: UTILITY METHODS
    // =========================================================================

    public void utilityExamples() {
        String numString = "12345";
        
        // Q: Difference between parseInt and valueOf?
        // A: parseInt returns primitive int. valueOf returns wrapper Integer.
        int primitive = Integer.parseInt(numString);
        Integer wrapper = Integer.valueOf(numString);
        System.out.println("Converted values: " + primitive + ", " + wrapper);

        // Accessing constant properties
        System.out.println("Max Integer: " + Integer.MAX_VALUE);
        System.out.println("Min Integer: " + Integer.MIN_VALUE);
    }

    // =========================================================================
    // SECTION 5: PERFORMANCE & NULL SAFETY
    // =========================================================================

    // Q: Most common bug with Wrappers? 
    // A: NullPointerException on Unboxing.
    public void npeRisk(Integer input) {
        // ERROR: If input is null, Java attempts to unbox it for a return type or logic.
        // int x = input; // Throws NPE if input is null.
        
        // SAFE
        if (input != null) {
            int safeInt = input;
            System.out.println("Safe unboxing: " + safeInt);
        }
    }

    /*
     * Memory Footprint:
     * Primitives are lightweight (int = 4 bytes).
     * Wrappers are heavy (Integer = 16-24 bytes due to object header).
     * PERFORMANCE TIP: In tight loops for mathematical operations, use primitives.
     */
}
