package OOPS;

/**
 * 📘 TOPIC 2: POLYMORPHISM
 * "Many Forms". Objects behaving differently based on their actual type.
 * Covers Compile-time (Overloading) and Runtime (Overriding) polymorphism.
 */
public class Polymorphism {

    // =========================================================================
    // SECTION 1: COMPILE-TIME POLYMORPHISM (Static Binding)
    // =========================================================================

    // Q: What is Method Overloading?
    // A: Having multiple methods with the same name but DIFFERENT PARAMETERS.
    // Parameter count, type, or order must vary. RETURN TYPE difference ALONE is NOT sufficient!
    static class Calculator {
        public int add(int a, int b) { return a + b; }
        
        // Overloaded methods
        public int add(int a, int b, int c) { return a + b + c; }
        public double add(double a, double b) { return a + b; }
    }

    // =========================================================================
    // SECTION 2: RUNTIME POLYMORPHISM (Dynamic Binding)
    // =========================================================================

    // Q: What is Dynamic Method Dispatch?
    // A: A parent class reference can point to a child class object. 
    // The version of the method called is determined at RUNTIME by the actual object type.
    static class Vehicle {
        public void start() {
            System.out.println("Generic Vehicle starting...");
        }
    }

    static class Bike extends Vehicle {
        @Override
        public void start() {
            System.out.println("Bike is starting (Kick start)!");
        }
    }

    static class Car extends Vehicle {
        @Override
        public void start() {
            System.out.println("Car is starting (Push button start)!");
        }
    }

    public void demonstrateRuntime() {
        System.out.println("--- 2. Runtime Polymorphism ---");
        
        // Reference (Parent) pointing to Object (Child)
        Vehicle v1 = new Bike(); 
        v1.start(); // Output: Bike is starting (Kick start)!

        Vehicle v2 = new Car();
        v2.start(); // Output: Car is starting (Push button start)!
        
        // Q: Why is this important?
        // A: It allows for LOOSE COUPLING. We can handle many types of vehicles 
        // using a single List<Vehicle> and just call start().
    }

    // =========================================================================
    // SECTION 3: KEY INTERVIEW QUESTIONS
    // =========================================================================

    /*
     * Q: Difference between compile-time and runtime polymorphism?
     * 1. Binding: Static vs Dynamic.
     * 2. Mechanism: Overloading vs Overriding.
     * 3. Rules: Same name, different params vs Same name, SAME params.
     * 
     * Q: Can we overload the main method?
     * A: YES, but JVM only calls public static void main(String[] args). Other versions 
     *    must be called manually within the original main method.
     * 
     * Q: Can static methods be overridden?
     * A: NO. Static methods are bound at compile-time to the class (Method Hiding).
     */

    public void demonstration() {
        Calculator calc = new Calculator();
        System.out.println("10 + 20: " + calc.add(10, 20));
        System.out.println("1.5 + 2.5: " + calc.add(1.5, 2.5));
        
        demonstrateRuntime();
    }
}
