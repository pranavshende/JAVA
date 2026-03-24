package Output;

import java.text.DecimalFormat;

/**
 * 📘 TOPIC: OUTPUT & CONSOLE COMMUNICATION
 * Understanding the console as an interface.
 * Covers println vs print, printf formatting, and DecimalFormat for currencies.
 */
public class OutputModule {

    // =========================================================================
    // SECTION 1: BASICS - Print vs Println
    // =========================================================================

    public void demonstratePrinting() {
        // Q: Difference between print and println?
        // A: 'println' appends a newline character (\n) after the text. 
        // A: 'print' leaves the cursor at the end of the text on the same line.
        
        System.out.println("Line 1 with newline");
        System.out.println("Line 2 with newline");
        
        System.out.print("No newline here: ");
        System.out.print("Wait, this is on the same line.");
        System.out.println(); // Manually add newline.
    }

    // =========================================================================
    // SECTION 2: CONSOLE FORMATTING (printf)
    // =========================================================================

    public void demonstrateFormatting() {
        // Q: How to format output for reports/tables?
        /*
         * A: 'printf' (print-formatted) is much cleaner than concatenation.
         * %s -> String, %d -> Integer, %f -> Float, %n -> Newline (portable)
         */
        String name = "Antigravity";
        int score = 42;
        double price = 129.99824;

        System.out.printf("User: %s | Score: %03d | Price: $%.2f %n", name, score, price);
        // Output: User: Antigravity | Score: 042 | Price: $130.00
    }

    // =========================================================================
    // SECTION 3: ESCAPE SEQUENCES
    // =========================================================================

    public void demonstrateEscapes() {
        // Q: How to print tab or quotes?
        System.out.println("Tabbed\tColumn");
        System.out.println("Quote: \"Java is awesome\"");
        System.out.println("Path: C:\\Users\\Desktop");
    }

    // =========================================================================
    // SECTION 4: SYSTEM.ERR VS SYSTEM.OUT
    // =========================================================================

    // Q: When to use System.err?
    // A: Use System.err (Error stream) for logging critical failures.
    // In many consoles, it appears in RED and can be separate from standard output.
    public void logError(String msg) {
        System.err.println("ALERT: " + msg);
    }

    // =========================================================================
    // SECTION 5: REAL-WORLD PROBLEM - Formatting Money
    // =========================================================================

    public void formatCurrency(double amount) {
        // Q: Why not use String rounding manually?
        // A: DecimalFormat provides a clean, localized pattern for reports.
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Formatted Balance: $" + df.format(amount));
    }

    /*
     * BEWARE: System.out.println is internally synchronized. 
     * Frequent calls in a tight loop from multiple threads will cause 
     * thread-contention and slow down your application significantly.
     */
}
