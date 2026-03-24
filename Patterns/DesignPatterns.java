package Patterns;

/**
 * 📘 TOPIC 13: DESIGN PATTERNS
 * Standardized solutions to common software design problems.
 * Covers Singleton, Factory, and Observer patterns.
 */
public class DesignPatterns {

    // =========================================================================
    // SECTION 1: SINGLETON PATTERN (Creational)
    // =========================================================================

    // Q: What is Singleton?
    // A: A class that only allows ONE instance of itself to be created.
    // It provides a single point of access (e.g., FileSystem, Database Connection).
    static class DatabaseConnection {
        private static DatabaseConnection instance;
        
        private DatabaseConnection() {} // Private Constructor (NO new)

        // Q: How to make it Thread-Safe?
        // A: 1. Synchronized method. (OR) 
        // A: 2. Double-Checked Locking (Fastest).
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
    }

    // =========================================================================
    // SECTION 2: FACTORY PATTERN (Creational)
    // =========================================================================

    // Q: What is the Factory Pattern?
    // A: Creating objects WITHOUT exposing the creation logic to the client. 
    // The client uses a common interface to refer to the new object.
    
    interface Notification { void notifyUser(); }
    static class PushNotification implements Notification { public void notifyUser() { System.out.println("Push notification sent."); } }
    static class EmailNotification implements Notification { public void notifyUser() { System.out.println("Email notification sent."); } }

    static class NotificationFactory {
        public static Notification create(String type) {
            if (type.equalsIgnoreCase("SMS")) return new PushNotification();
            if (type.equalsIgnoreCase("EMAIL")) return new EmailNotification();
            throw new IllegalArgumentException("Unknown notification type.");
        }
    }

    public void demonstrateFactory() {
        System.out.println("--- 2. Factory Pattern ---");
        Notification n = NotificationFactory.create("EMAIL");
        n.notifyUser();
    }

    // =========================================================================
    // SECTION 3: OBSERVER PATTERN (Behavioral)
    // =========================================================================

    // Q: What is Observer Pattern?
    // A: A 1-to-Many dependency where if one object changes state, 
    // all its dependents are notified automatically (e.g., YouTube subscribers).
    
    // NOTE: This usually involves a Subject interface and Observer interface.
    // It's the core of Event-driven systems.

    // =========================================================================
    // SECTION 4: BUILDER PATTERN (Creational)
    // =========================================================================

    // Q: When to use Builder?
    // A: When an object has too many parameters, making the constructor messy.
    // String s = new UserBuilder().setName("Bob").setAge(25).build();

    // =========================================================================
    // SECTION 5: KEY INTERVIEW QUESTIONS
    // =========================================================================

    /*
     * Q: Why favor Composition over Inheritance?
     * A: 1. Loose Coupling (Changing parent doesn't break everything).
     * A: 2. Flexibility (Can change behavior at runtime).
     * A: 3. Prevents class-explosion (Avoiding deep inheritance chains).
     */
}
