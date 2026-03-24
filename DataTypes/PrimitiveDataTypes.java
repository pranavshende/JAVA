package DataTypes;

/**
 * 📘 TOPIC 2.1: PRIMITIVE DATA TYPES
 * Java provides 8 primitive data types for storing raw values directly in memory (Stack).
 * Primitives are fast, efficient, and have fixed sizes defined by the JVM.
 */
public class PrimitiveDataTypes {

    public void demonstrateAllPrimitives() {
        // --- 1. Integer Types ---
        
        // Byte: 8-bit, -128 to 127. Good for memory-constrained I/O buffers.
        byte myByte = 127; 
        
        // Short: 16-bit, -32,768 to 32,767. Rarely used today.
        short myShort = 32767;
        
        // Int: 32-bit (Default). Range: -2^31 to 2^31-1. Choice for standard numbers.
        int myInt = 2147483647;
        
        // Long: 64-bit. Range: -2^63 to 2^63-1. Requires suffix 'L'.
        long myLong = 9223372036854775807L;

        // --- 2. Floating Point Types ---
        
        // Float: 32-bit single precision. Requires suffix 'f'.
        float myFloat = 3.14159f;
        
        // Double: 64-bit double precision (Default).
        double myDouble = 3.141592653589793;

        // --- 3. Character & Boolean ---
        
        // Char: 16-bit Unicode character. 
        char myChar = 'A';
        char myUnicode = '\u0041'; // 'A' in Unicode

        // Boolean: Logic values true or false. 
        boolean isJavaFun = true;

        // OUTPUT Demonstration
        System.out.println("Integer values: byte=" + myByte + ", short=" + myShort + ", int=" + myInt + ", long=" + myLong);
        System.out.println("Decimal values: float=" + myFloat + ", double=" + myDouble);
        System.out.println("Character/Boolean: char=" + myChar + " (" + myUnicode + "), boolean=" + isJavaFun);
    }

    /*
     * INTERVIEW Q&A:
     * 1. Q: Why do float/double need suffixes 'f' and 'd'?
     *    A: Whole numbers default to 'int' and decimals default to 'double'. 
     *       We needsuffixes to force the compiler to treat them as 'float' or 'long'.
     *
     * 2. Q: What is the default value of local primitives?
     *    A: Local variables have NO default values. They MUST be initialized before use.
     *       Instance variables (fields) have defaults: 0 for numeric, false for boolean, '\u0000' for char.
     */
    
    public static void main(String[] args) {
        new PrimitiveDataTypes().demonstrateAllPrimitives();
    }
}