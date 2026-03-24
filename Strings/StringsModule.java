package Strings;

/**
 * 📘 TOPIC: STRINGS
 * One of the most important concepts in Java.
 * Covers Immutability, the String Pool, StringBuilder, and basic operations.
 */
public class StringsModule {

    // =========================================================================
    // SECTION 1: BASICS - Immutability & Pool
    // =========================================================================

    public void demonstrateImmutability() {
        // Q: What does "Strings are Immutable" mean?
        // A: Once a String object is created, its value CANNOT be changed.
        String original = "Java";
        String modified = original.concat(" Practice"); 
        
        System.out.println("Original: " + original); // Still "Java"
        System.out.println("Modified: " + modified); // New object "Java Practice"
        
        // Q: Why are Strings immutable?
        // A: 1. Security (Strings are used as arguments for network/file paths).
        // 2. Multithreading (Immutable objects are thread-safe).
        // 3. Performance (String Constant Pool).
    }

    // =========================================================================
    // SECTION 2: THE STRING POOL (Heap vs Pool)
    // =========================================================================

    // Q: Difference between String Literal and 'new String()'?
    public void demonstrationPool() {
        String s1 = "Java"; // Created in the String Constant Pool (Heap).
        String s2 = "Java"; // Points to the same object in the Pool.
        String s3 = new String("Java"); // FORCES new object creation in general Heap.

        System.out.println("--- 2. String Pool ---");
        System.out.println("s1 == s2: " + (s1 == s2)); // true (Same reference)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (Different reference)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (Same content)
    }

    // =========================================================================
    // SECTION 3: STRINGBUILDER & STRINGBUFFER (Advanced)
    // =========================================================================

    // Q: String vs StringBuilder vs StringBuffer?
    /*
     * String: Immutable, safe but slow for many concatenations.
     * StringBuilder: MUTABLE, very fast, NOT thread-safe. (Preferred for single-thread).
     * StringBuffer: MUTABLE, thread-safe (synchronized), slow. (Legacy/multi-thread).
     */
    public void demonstrateStringBuilder() {
        System.out.println("--- 3. StringBuilder ---");
        StringBuilder sb = new StringBuilder("Start");
        for (int i = 0; i < 5; i++) {
            sb.append(" ").append(i); // Efficiently modifies the same object.
        }
        System.out.println("Final SB: " + sb.toString());
    }

    // =========================================================================
    // SECTION 4: USEFUL METHODS
    // =========================================================================

    public void commonMethods(String data) {
        if (data == null || data.isEmpty()) return;
        
        System.out.println("--- 4. String Methods ---");
        System.out.println("Length: " + data.length());
        System.out.println("Substring (0-2): " + data.substring(0, 2));
        System.out.println("Uppercase: " + data.toUpperCase());
        System.out.println("Contains 'J': " + data.contains("J"));
        System.out.println("Replaced: " + data.replace('a', '@'));
        System.out.println("Trimmed: " + "  spaces  ".trim());
    }

    // =========================================================================
    // SECTION 5: INTERVIEW PROBLEM - Reverse a String
    // =========================================================================

    public String reverseString(String input) {
        if (input == null) return null;
        
        // Efficient way:
        return new StringBuilder(input).reverse().toString();
        
        // Manual way (Char by char) is also common in interviews.
    }

    // =========================================================================
    // SECTION 6: PERFORMANCE PITFALL
    // =========================================================================

    /*
     * DANGER: Creating Strings in a Loop with '+' operator.
     * String s = "";
     * for (...) { s += "data"; } // INTERNALLY creates new StringBuilder + String every time!
     * 
     * FIX: Use StringBuilder explicitly inside the loop.
     */
}
