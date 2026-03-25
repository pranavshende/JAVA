package OOPS.v06_Polymorphism;

/**
 * 📘 TOPIC: POLYMORPHISM
 * 
 * 1. Compile-time Polymorphism: Method Overloading (Static Binding).
 * 2. Runtime Polymorphism: Method Overriding (Dynamic Binding).
 */

// [1] COMPILE-TIME: Method Overloading
// Same method name, different parameters.
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }

    // INTERVIEW FOCUS:
    // Can overloading be done by changing return type ONLY?
    // NO. Only parameters must be different.
    // double add(int a, int b) { return a + b; } // INCORRECT
}

/**
 * [2] RUNTIME: Method Overriding
 * 
 * Same method name, same parameters, different implementation in subclass.
 */
class PaymentProcessor {
    void processPayment(double amount) {
        System.out.println("Processing basic payment of $" + amount);
    }
}

class PayPal extends PaymentProcessor {
    @Override // Good practice to use @Override
    void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " (Includes fees)");
    }
}

class CreditCard extends PaymentProcessor {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " (Secure Transaction)");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("--- Method Overloading ---");
        Calculator calc = new Calculator();
        System.out.println("Sum (2 nums): " + calc.add(10, 20));
        System.out.println("Sum (3 nums): " + calc.add(10, 20, 30));
        System.out.println("Sum (double): " + calc.add(10.5, 20.5));

        System.out.println("\n--- Method Overriding (Runtime Polymorphism) ---");
        // Superclass reference pointing to subclass object
        PaymentProcessor p1 = new PayPal();
        PaymentProcessor p2 = new CreditCard();
        
        // At runtime, the JVM decides which method to call based on the ACTUAL object.
        p1.processPayment(100.0); // Output: PayPal payment...
        p2.processPayment(200.0); // Output: Credit Card payment...

        // [3] INTERVIEW FOCUS:
        // Why call this "Dynamic Dispatch"?
        // Because the decision of which method to call is made at RUNTIME.

        // [4] EDGE CASE: Static methods cannot be overridden!
        // Static methods belong to the CLASS, not the instance.
        // This is called Method Hiding, not Overriding.
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Dynamic Dispatch):
 * 1. p1 is declared as PaymentProcessor (Reference type).
 * 2. p1 points to PayPal object (Object type).
 * 3. p1.processPayment() is called.
 * 4. JVM checks PayPal class for processPayment().
 * 5. Found it! Executed PayPal version instead of PaymentProcessor version.
 */
