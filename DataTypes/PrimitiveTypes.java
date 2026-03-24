package DataTypes;

/**
 * 📘 TOPIC 2.3: ADVANCED PRIMITIVES & OVERFLOWS
 * Understanding how Java handles memory ranges and the concept of "wrapping around"
 * during numeric overflows.
 */
public class PrimitiveTypes {

    public void demonstrateOverflow() {
        // 1. Integer Overflow
        // Max Int + 1 results in Min Int due to 2's complement representation.
        int maxInt = Integer.MAX_VALUE;
        int overflowed = maxInt + 1;
        System.out.println("Max Int: " + maxInt);
        System.out.println("Overflowed Int (Max + 1): " + overflowed); // Output: -2147483648

        // 2. Character Arithmetic
        // Characters are treated as 16-bit unsigned integers internally.
        char letter = 'A'; // ASCII 65
        letter++; // becomes 'B' (ASCII 66)
        System.out.println("Incremented char: " + letter); 
        
        // Cast to int to see the internal numeric value
        System.out.println("Character as Integer: " + (int) letter);
    }

    /*
     * INTERVIEW FOCUS:
     * Q: Why does 1.1 + 2.2 not equal 3.3 in Java?
     * A: Java uses IEEE 754 floating point standard. Decimals like 0.1 cannot be represented
     *    accurately in binary, causing tiny precision losses that accumulate.
     */
    
    public static void main(String[] args) {
        new PrimitiveTypes().demonstrateOverflow();
    }
}