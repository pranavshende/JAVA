package OOPS.v22_Design_Patterns;

/**
 * 📘 TOPIC: DESIGN PATTERNS
 * 
 * 1. Singleton: Ensures a class has only one instance and provides mapping to it.
 * 2. Factory: Creates objects without exposing the instantiation logic to the client.
 */

// =========================================================================
// [1] ADVANCED: Singleton Pattern (Thread-safe)
// =========================================================================

class DatabaseConnection {
    // Volatile for Double-Checked Locking thread safety
    private static volatile DatabaseConnection instance;
    private String connectionString;

    // PRIVATE constructor: Cannot be instantiated from outside.
    private DatabaseConnection() {
        this.connectionString = "jdbc:postgresql://localhost:5432/main_db";
        System.out.println("--- NEW DB CONNECTION OPENED ---");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing: " + sql + " on " + connectionString);
    }
}

// =========================================================================
// [2] INTERMEDIATE: Factory Pattern
// =========================================================================

interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override public void notifyUser() { System.out.println("Email Sent!"); }
}

class SMSNotification implements Notification {
    @Override public void notifyUser() { System.out.println("SMS Sent!"); }
}

// The Factory: Logic of creation is HERE
class NotificationFactory {
    public static Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) return null;
        switch (channel.toUpperCase()) {
            case "EMAIL": return new EmailNotification();
            case "SMS": return new SMSNotification();
            default: throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}

public class DesignPatternsDemo {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern ---");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        db1.query("SELECT * FROM users");
        
        System.out.println("Are db1 and db2 SAME instance? " + (db1 == db2)); // Should be TRUE

        System.out.println("\n--- Factory Pattern ---");
        Notification n1 = NotificationFactory.createNotification("EMAIL");
        Notification n2 = NotificationFactory.createNotification("SMS");
        
        n1.notifyUser();
        n2.notifyUser();

        // [3] INTERVIEW FOCUS:
        // Q: Why Factory?
        // A: Decouples the client from the implementation. Client doesn't need to know which class 
        // they are using, just the interface!
        
        // Q: Singleton: What is "Lazy Initialization"?
        // A: Creating the instance ONLY when getInstance() is called for the first time.
    }
}

/**
 * 💡 DRY RUN SUMMARY (Patterns):
 * 1. db1 calls getInstance() -> instance is null -> synchronization -> creates instance.
 * 2. db2 calls getInstance() -> instance NOT null -> returns existing instance.
 * 3. NotificationFactory.createNotification("EMAIL") returns an EmailNotification object.
 * 4. n1.notifyUser() calls our overridden method in EmailNotification.
 */
