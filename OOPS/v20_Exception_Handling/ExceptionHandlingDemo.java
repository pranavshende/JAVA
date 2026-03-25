package OOPS.v20_Exception_Handling;

/**
 * 📘 TOPIC: EXCEPTION HANDLING
 * 
 * 1. try-catch: Handling exceptions at runtime.
 * 2. finally: Block that executes regardless of exception (Resource Cleanup).
 * 3. throw: Manually throwing an exception.
 * 4. throws: Declaring that a method might throw an exception.
 * 5. Custom Exception: Creating user-defined exceptions.
 */

// [1] ADVANCED: Creating a Custom Exception
// Inheriting from RuntimeException (Unchecked) or Exception (Checked)
class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        super("Insufficient balance: You are short by $" + amount);
        this.amount = amount;
    }

    public double getAmount() { return amount; }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) { this.balance = balance; }

    // [2] INTERMEDIATE: Using throws
    // We declare the method might throw our custom exception.
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdawn: $" + amount + ". Remaining: $" + balance);
        } else {
            // [3] BASIC: Using throw
            double shortBy = amount - balance;
            throw new InsufficientFundsException(shortBy);
        }
    }
}

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        System.out.println("--- Basic Try-Catch-Finally ---");
        try {
            @SuppressWarnings("unused") int a = 10;
            @SuppressWarnings("unused") int b = 0;
            // int c = a / b; // This would throw ArithmeticException
            System.out.println("Try block executed successfully.");
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block: This runs no matter what!");
        }

        System.out.println("\n--- Custom Exception Handling ---");
        BankAccount acc = new BankAccount(500.0);
        
        try {
            acc.withdraw(1000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Multiple Catch Blocks ---");
        try {
            @SuppressWarnings("unused") String str = null;
            // System.out.println(str.length()); // Would throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointer!");
        } catch (Exception e) {
            System.out.println("Caught generic Exception!");
        }

        // [4] INTERVIEW FOCUS:
        // Q: Difference between Checked and Unchecked exceptions?
        // A: Checked (e.g. IOException) must be handled at compile-time. 
        // Unchecked (e.g. NullPointerException) occur at runtime.
        
        // Q: Can we have try without catch?
        // A: YES, but only if we have a finally block (try-finally).
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Exception Handling):
 * 1. Acc balance = 500. Withdraw(1000).
 * 2. 1000 > 500 is true.
 * 3. throw new InsufficientFundsException(500) is executed.
 * 4. The exception object propagates to the main method's catch block.
 * 5. Catch block prints the message and handles the error gracefully.
 */
