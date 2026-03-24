package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 📘 TOPIC: EXCEPTION HANDLING
 * Complete guide to handling runtime errors and maintaining application flow.
 * Covers try-catch-finally, checked vs unchecked, and best practices.
 */
public class ExceptionModule {

    // =========================================================================
    // SECTION 1: BASICS - Try, Catch, Finally
    // =========================================================================

    public void demonstrateBasics(int a, int b) {
        try {
            // ArithmeticException (Unchecked)
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Q: Why catch specifically? 
            // A: Catching generic 'Exception' is a bad practice. Catches specific errors.
            System.err.println("CRITICAL: Division by zero is not allowed.");
        } finally {
            // Q: What is the purpose of 'finally'?
            // A: Used for cleanup (closing connections). Executes REGARDLESS of error.
            System.out.println("Execution flow continues...");
        }
    }

    // =========================================================================
    // SECTION 2: CHECKED vs UNCHECKED EXCEPTIONS
    // =========================================================================

    // Q: What is a Checked Exception? (Compile-time)
    // A: Must be handled with try-catch OR declared with 'throws'. Example: IOException.
    public void checkedExceptionMethod() throws IOException {
        try (FileReader fr = new FileReader("test.txt")) {
            // Processing file
        }
    }

    // Q: What is an Unchecked Exception? (Runtime)
    // A: Extends from RuntimeException. Not forced by compiler. Example: NullPointerException.
    public void unCheckedExceptionMethod(String data) {
        if (data == null) throw new NullPointerException("Data cannot be null!");
    }

    // =========================================================================
    // SECTION 3: TRY-WITH-RESOURCES (Java 7+)
    // =================================== ======================================

    // Q: Benefit of try-with-resources?
    // A: Automatically closes resources (implements AutoCloseable) after block finish.
    public void autoCleanup() {
        try (BufferedReader br = new BufferedReader(new FileReader("dummy.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.err.println("File IO failed.");
        }
        // No finally block needed to close BufferedReader!
    }

    // =========================================================================
    // SECTION 4: MULTI-CATCH & THROW vs THROWS
    // =========================================================================

    // Q: Multi-catch benefit?
    // A: Cleaner code when multiple exceptions require identical handling.
    public void multiCatch() {
        try {
            int[] arr = new int[2];
            arr[5] = 10 / 0; // Throws potentially Arithmetic or IndexOutOfBounds
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Generic calculation/access error: " + e.getMessage());
        }
    }

    // Q: Difference between throw and throws?
    // A: 'throw' is used to manually trigger an exception (inside method).
    // A: 'throws' is a signature keyword (declares method might fail).

    // =========================================================================
    // SECTION 5: CUSTOM EXCEPTIONS & BEST PRACTICES
    // =========================================================================

    // Q: When to create custom exceptions?
    // A: When standard Java exceptions don't clearly describe your business logic failure.
    public void checkBalance(double balance) throws InsufficientFundsException {
        if (balance < 100) {
            throw new InsufficientFundsException("Account must maintain $100 minimum.");
        }
    }

    // Interview Tip: Never catch Throwable. Don't swallow exceptions.
    // Performance: Exceptions are expensive because building the Stack Trace consumes CPU.
}

// Custom Exception Definition
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
