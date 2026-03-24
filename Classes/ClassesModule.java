package Classes;

/**
 * 📘 TOPIC: CLASSES & OBJECTS
 * The blueprint vs the house. Complete guide to modeling real-world data in Java.
 * Covers Encapsulation, Constructors, Access Modifiers, and the Static keyword.
 */
public class ClassesModule {

    // =========================================================================
    // SECTION 1: BASICS - The Student Blueprint
    // =========================================================================

    // Student is a Class (Blueprint)
    static class Student {
        // Attributes (Fields / State)
        private int roll;
        private String name;
        
        // Static Member: Shared across all Student objects.
        static String college = "SVPCET"; 
        
        // Final Member: Immutable per object.
        final String course = "BTech";

        // Constructor: For initializing object state.
        public Student(int roll, String name) {
            this.roll = roll;   // 'this' refers to current object attribute.
            this.name = name;
        }

        // Behavior (Methods)
        public void display() {
            System.out.println("Roll: " + roll + " | Name: " + name);
            System.out.println("College: " + college + " | Course: " + course + "\n");
        }
    }

    // =========================================================================
    // SECTION 2: ACCESS MODIFIERS - Encapsulation (Interview Favorite)
    // =========================================================================

    /*
     * Q: What is Encapsulation?
     * A: Restricting direct access (private) and providing indirect access 
     *    (public getter/setters). This allows for validation and hide logic details.
     */
    static class ProtectedClass {
        private double balance; // Secure!

        // Getter
        public double getBalance() { return balance; }

        // Setter with logic
        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
            }
        }
    }

    // =========================================================================
    // SECTION 3: PASS-BY-VALUE vs PASS-BY-REFERENCE (Tricky Interview Question)
    // =========================================================================

    /*
     * Q: Is Java pass-by-reference?
     * A: NO. Java is strictly PASS-BY-VALUE. 
     * For objects, the VALUE of the reference (memory address) is passed.
     * Reassigning the reference inside a method won't change it outside.
     * Modifying the object's INTERNAL state DOES persist.
     */
    public void passByValueExplanation(Student s) {
        s = new Student(999, "Temporary"); // Won't change original s in main()
        s.display(); 
    }

    // =========================================================================
    // SECTION 4: SINGLETON PATTERN - Real-world Architecture
    // =========================================================================

    // Q: When would you want only ONE object for a class?
    // A: Database Connection Pool, Configuration Managers, Loggers.
    static class DatabaseConnection {
        private static DatabaseConnection instance;
        
        private DatabaseConnection() {} // Private Constructor prevents manual creation.

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }
    }

    // =========================================================================
    // SECTION 5: MEMORY (Stack vs Heap)
    // =========================================================================

    /*
     * stack: Stores local variables and reference pointers.
     * heap: Stores the actual objects and arrays.
     * If an object has no references pointing to it, the Garbage Collector reclaims it.
     */

    public static void main(String[] args) {
        Student s1 = new Student(101, "Pranav");
        Student s2 = new Student(102, "Rahul");
        
        System.out.println("--- 1. Objects Demo ---");
        s1.display();
        s2.display();
        
        System.out.println("--- 2. Static Context ---");
        // Static belongs to class, not s1 or s2.
        System.out.println("Common College: " + Student.college);
        
        System.out.println("Classes module initialized.");
    }
}
