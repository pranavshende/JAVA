package OOPS.v12_Final_Keyword;

/**
 * 📘 TOPIC: FINAL KEYWORD
 * 
 * 1. Final Variables: Creating constants (cannot be reassigned).
 * 2. Final Methods: Preventing method overriding.
 * 3. Final Classes: Preventing inheritance (Useful for security/immutability).
 */

// [1] BASIC: Final Variable
class DatabaseConfig {
    // Constant value
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    
    // Final field must be initialized either here or in constructor
    final int TIMEOUT_SECONDS;

    DatabaseConfig(int timeout) {
        this.TIMEOUT_SECONDS = timeout;
    }

    void showConfig() {
        System.out.println("DB URL: " + DB_URL + ", Timeout: " + TIMEOUT_SECONDS);
    }

    // [2] INTERMEDIATE: Final Method
    // This method CANNOT be overridden by child classes.
    final void connect() {
        System.out.println("Connecting to the database...");
    }
}

// [3] ADVANCED: Final Class
// This class CANNOT be extended!
final class SecurityManager {
    void authenticate(String user) {
        System.out.println("Authenticating: " + user);
    }
}

// INCORRECT USAGE (Compiled Error):
/*
class CustomDatabase extends DatabaseConfig {
    @Override
    void connect() { } // COMPILE ERROR: Cannot override final method.
}

class CustomSecurity extends SecurityManager { } // COMPILE ERROR: Cannot inherit from final class.
*/

public class FinalDemo {
    public static void main(String[] args) {
        System.out.println("--- Final Variables Example ---");
        DatabaseConfig config = new DatabaseConfig(10);
        config.showConfig();

        // config.TIMEOUT_SECONDS = 20; // COMPILE ERROR: Cannot reassign final variable.

        System.out.println("\n--- Final Method calling ---");
        config.connect();

        System.out.println("\n--- Final Class Demo ---");
        SecurityManager sm = new SecurityManager();
        sm.authenticate("Admin");

        // [4] INTERVIEW FOCUS:
        // Q: Can a class be both abstract and final?
        // A: NO. Abstract classes MUST be extended, and final classes CANNOT be extended. Contradiction!
        
        // Q: Difference between 'final', 'finally', and 'finalize'?
        // A: 'final' is a modifier. 'finally' is a block in exception handling. 'finalize' is an Object class method.
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Final):
 * 1. TIMEOUT_SECONDS is assigned once during constructor call.
 * 2. DB_URL is a static constant (Global).
 * 3. Final check: JVM ensures NO child class can modify the 'connect' behavior or inherit SecurityManager.
 */
