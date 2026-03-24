package Syntax;

/**
 * 📘 TOPIC 0: JAVA SYNTAX & STRUCTURE
 * The starting point for every Java application.
 * Covers class structure, the main method, comments, and printing.
 */
public class Syntax {

    // Q: Why must every Java program have a class?
    // A: Java is an Object-Oriented language; everything (data and behavior) lives inside classes.
    // Rule: The filename MUST match the public class name (Syntax.java -> public class Syntax).

    /**
     * Q: What is the significance of the main method signature?
     * public: Accessible from anywhere (JVM needs to call it).
     * static: Can be called without creating an instance of the class.
     * void: Does not return any value.
     * main: The identifier the JVM looks for as the entry point.
     * String[] args: Command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        
        // =====================================================================
        // SECTION 1: PRINTING TO CONSOLE
        // =====================================================================
        
        // System.out.println() prints and moves to the next line.
        System.out.println("Hello, Java Practice!"); 
        
        // System.out.print() prints without a newline.
        System.out.print("This is on ");
        System.out.print("the same line.");
        System.out.println(); // Just a newline

        // =====================================================================
        // SECTION 2: COMMENTS
        // =====================================================================

        // Single-line comment
        
        /*
         * Multi-line comment
         * used for longer explanations.
         */
        
        /**
         * Documentation comment (JavaDoc)
         * Used to generate API documentation (appears in IDE tooltips).
         */

        // =====================================================================
        // SECTION 3: KEY SYNTAX RULES & PITFALLS
        // =====================================================================

        // 1. Case Sensitivity: 'MyVar' and 'myvar' are different.
        int myVar = 10;
        int MyVar = 20;
        System.out.println("myVar: " + myVar + " | MyVar: " + MyVar);

        // 2. Semicolons: Every statement MUST end with a semicolon (;).
        // Missing one is the #1 cause of compilation errors for beginners.

        // 3. Curly Braces {}: Define the scope of classes and methods.
        
        // 4. Common Mistake: Forgetting 'static' in main method.
        // Result: "Main method not found in class Syntax, please define the main method as:
        // public static void main(String[] args)"
    }

    /**
     * Performance Consideration:
     * System.out.println is slow because it involves disk/console I/O 
     * and is synchronized (thread-safe). In high-performance logging, 
     * use dedicated frameworks like Log4j or SLF4J which handle I/O asynchronously.
     */
    public void demonstration() {
        System.out.println("Syntax module initialized.");
    }
}