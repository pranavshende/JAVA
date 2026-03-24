package OOPS;

/**
 * 📘 TOPIC 3: ABSTRACTION
 * "Showing what is essential and hiding background details".
 * Covers Abstract Classes and Interfaces.
 */
public class Abstraction {

    // =========================================================================
    // SECTION 1: ABSTRACT CLASS (Partial Implementation)
    // =========================================================================

    // Q: What is an Abstract Class?
    // A: A class declared with 'abstract'. It CANNOT be instantiated directly.
    // It can have both abstract (not implemented) and concrete (implemented) methods.
    static abstract class Shape {
        String color;

        public Shape(String color) { this.color = color; }

        // Abstract method: MUST be implemented by child classes.
        public abstract double calculateArea();

        // Concrete method: Common functionality.
        public void display() {
            System.out.println("Shape color: " + color);
        }
    }

    static class Circle extends Shape {
        double radius;

        public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    // =========================================================================
    // SECTION 2: INTERFACES (Full Abstraction)
    // =========================================================================

    // Q: What is an Interface?
    // A: A blueprint for a class. It defines behavior (What an object can do).
    // All methods are public and abstract by default (until Java 8).
    interface Playable {
        // Q: Variables in interfaces?
        // A: are public, static, and final by default.
        String TYPE = "Multimedia";

        void play(); // public abstract
        
        // Java 8+ features:
        // Default methods: Concrete methods in interfaces.
        default void stop() {
            System.out.println("Stopping the playback...");
        }

        // Static methods: Utility methods in interfaces.
        static void info() {
            System.out.println("This is a Playable device.");
        }
    }

    // Q: Difference between Abstract Classes and Interfaces?
    /*
     * 1. Keywords: abstract class vs interface.
     * 2. Implementation: extends (Single) vs implements (Multiple).
     * 3. Variables: Any access modifier vs only public, static, final.
     * 4. Purpose: Representing "IS-A" relationships vs "CAN-DO" behaviors.
     */

    // =========================================================================
    // SECTION 3: MULTIPLE INHERITANCE IN JAVA
    // =========================================================================

    interface Wireless { void connectWiFi(); }
    interface Bluetooth { void connectBT(); }

    // Q: How does Java support Multiple Inheritance?
    // A: Through Interfaces. A class can implement multiple interfaces!
    static class SmartPhone implements Wireless, Bluetooth {
        public void connectWiFi() { System.out.println("Connecting to WiFi..."); }
        public void connectBT() { System.out.println("Connecting to Bluetooth..."); }
    }

    // =========================================================================
    // SECTION 4: KEY INTERVIEW QUESTIONS
    // =========================================================================

    /*
     * Q: Can an abstract class have a constructor?
     * A: YES. It's used to initialize fields of the abstract class (via super in children).
     * 
     * Q: Can we have an abstract method in a non-abstract class?
     * A: NO. If a class has at least one abstract method, the class MUST be abstract.
     * 
     * Q: Why use interfaces over abstract classes?
     * A: To favor Composition over Inheritance, and to implement multiple behaviors.
     */

    public void demonstrate() {
        Circle c = new Circle("Red", 5.0);
        c.display();
        System.out.println("Circle Area: " + c.calculateArea());

        SmartPhone phone = new SmartPhone();
        phone.connectWiFi();
        phone.connectBT();
    }
}
