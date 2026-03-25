package OOPS.v16_Inner_Classes;

/**
 * 📘 TOPIC: INNER CLASSES
 * 
 * 1. Member Inner Class: Non-static class inside another class.
 * 2. Static Nested Class: Static class inside another class.
 * 3. Local Inner Class: Class defined inside a method.
 */

// [1] BASIC: Member Inner Class
class Outer {
    private String outerField = "Outer field value";

    class Inner {
        void display() {
            // Inner classes CAN access private members of outer classes!
            System.out.println("Inner: Accessing " + outerField);
        }
    }

    // [2] INTERMEDIATE: Static Nested Class
    static class StaticNested {
        void display() {
            System.out.println("StaticNested: Cannot access " + "outerField" + " (Non-static)!");
        }
    }

    // [3] ADVANCED: Local Inner Class
    void validate() {
        class Validator {
            void check(String data) {
                if (data == null) System.out.println("Validator: FAILED!");
                else System.out.println("Validator: PASSED!");
            }
        }
        Validator v = new Validator();
        v.check("Java OOPs");
    }
}

public class InnerClassesDemo {
    public static void main(String[] args) {
        System.out.println("--- Inner Classes Demonstration ---");

        // [4] BASIC: Initializing Member Inner Class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Special syntax: outerObject.new Inner()
        inner.display();

        // [5] INTERMEDIATE: Initializing Static Nested Class
        Outer.StaticNested nested = new Outer.StaticNested(); // Normal syntax
        nested.display();

        // [6] ADVANCED: Local Inner Class call
        outer.validate();

        // [7] INTERVIEW FOCUS:
        // Q: Why use inner classes?
        // A: To logically group classes only used in one place. Better encapsulation.
        
        // Q: Difference between Inner and Static Nested?
        // A: Inner class HAS a reference to the outer object. Static Nested does NOT.
    }
}

/**
 * 💡 DRY RUN SUMMARY (Inner Classes):
 * 1. Outer object is created in memory.
 * 2. inner object is linked to outer (it has a hidden pointer to 'outer').
 * 3. nested object is independent and only exists within the 'Outer' namespace.
 * 4. validate() creates a temporary Validator class on the stack, used once, then discarded.
 */
