package OOPS.v14_Method_Overloading_Overriding;

/**
 * 📘 TOPIC: METHOD OVERLOADING VS OVERRIDING
 * 
 * 1. Overloading (Compile-Time): Same name, different parameters (Number or Type).
 * 2. Overriding (Runtime): Same name, same parameters, in a subclass.
 */

// [1] OVERLOADING: Many methods, same name
class MathOperations {
    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
    double add(double a, double b) { return a + b; }

    // [2] INTERMEDIATE: Overloading with different order/types!
    void display(String msg, int num) { System.out.println(msg + " : " + num); }
    void display(int num, String msg) { System.out.println(num + " : " + msg); }
}

// [3] OVERRIDING: Base behavior vs Specific behavior
class SmartDevice {
    void turnOn() { System.out.println("--- Booting Device ---"); }
}

class Phone extends SmartDevice {
    @Override // Good practice to use @Override
    void turnOn() {
        System.out.println("--- Phone Logo Appears (Boots faster) ---");
    }

    // [4] INTERVIEW FOCUS:
    // Q: Can we override a static method? 
    // A: NO. Only instance methods can be overridden.
    
    // Q: Can we override a final method?
    // A: NO. Final means it's the final version.
}

public class OverloadOverrideDemo {
    public static void main(String[] args) {
        System.out.println("--- Method Overloading ---");
        MathOperations math = new MathOperations();
        System.out.println("Add 2: " + math.add(10, 20));
        System.out.println("Add 3: " + math.add(10, 20, 30));
        math.display("Count", 5);
        math.display(10, "Units");

        System.out.println("\n--- Method Overriding ---");
        SmartDevice device1 = new SmartDevice();
        SmartDevice device2 = new Phone(); // Runtime Polymorphism
        
        device1.turnOn(); // Base version
        device2.turnOn(); // Overridden Phone version executed!

        // [5] INCORRECT USAGE:
        // double add(int a, int b) { return a + b; } // Overloading FAILS if only return type changes!
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. For math.add(10, 20), compiler maps it to 'add(int, int)' during compilation.
 * 2. For math.add(10.5, 5.5), compiler maps it to 'add(double, double)'.
 * 3. device2 is of type SmartDevice (Reference) but points to a Phone (Object).
 * 4. At RUNTIME, JVM checks the Phone class, finds turnOn(), and executes it.
 */
