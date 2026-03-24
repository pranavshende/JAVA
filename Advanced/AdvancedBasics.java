package Advanced;

/**
 * 📘 TOPIC 8: ADVANCED BASICS
 * Exploring Inner Classes and Enums.
 * These structures help model data more precisely.
 */
public class AdvancedBasics {

    // =========================================================================
    // SECTION 1: INNER CLASSES (Nested Types)
    // =========================================================================

    // Q: Inner Classes vs Static Nested Classes?
    /*
     * Inner Class: Linked to an instance of the Outer class. (Outer.new Inner()).
     * Static Nested Class: Linked ONLY to the Outer class definition. (Outer.Inner()).
     */
    static class Outer {
        private String secret = "TopSecretValue";

        // Non-static Inner Class
        class Inner {
            void accessOuter() {
                // Can access ANY member of outer class (even private)
                System.out.println("Inner: Accessing " + secret);
            }
        }

        // Static Nested Class
        static class StaticNested {
            void info() {
                System.out.println("Static Nested Class: No instance needed.");
                // System.out.println(secret); // ERROR: Cannot access non-static member!
            }
        }
    }

    public void demonstrateInnerClasses() {
        System.out.println("--- 1. Inner Classes ---");
        
        // Static Nested (No Outer object needed)
        Outer.StaticNested sn = new Outer.StaticNested();
        sn.info();

        // Non-static Inner (Outer object REQUIRED)
        Outer o = new Outer();
        Outer.Inner i = o.new Inner(); // Special syntax
        i.accessOuter();
    }

    // =========================================================================
    // SECTION 2: ANONYMOUS CLASSES (Quick Implementations)
    // =========================================================================

    // Q: When to use an Anonymous Inner Class?
    // A: When you need a one-time implementation of an interface or abstract class.
    public void demonstrateAnonymousClass() {
        System.out.println("--- 2. Anonymous Classes ---");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() { System.out.println("Thread running from anonymous class!"); }
        });
        t.start();
        
        // NOTE: In modern Java, these are usually replaced by Lambdas.
    }

    // =========================================================================
    // SECTION 3: ENUMS (Enumerations)
    // =========================================================================

    // Q: What is an Enum?
    // A: A special "class" representing a group of constants (unchangeable variables).
    // It's more powerful than static final ints (it provides type-safety).
    public enum Level {
        LOW(10), MEDIUM(50), HIGH(100);

        // Enums can have fields, constructors, and methods!
        private final int value;

        Level(int value) { this.value = value; }

        public int getValue() { return value; }
    }

    public void demonstrateEnums() {
        System.out.println("--- 3. Enums ---");
        Level myLevel = Level.MEDIUM;

        // Switch with Enums (CLEAN!)
        switch (myLevel) {
            case LOW -> System.out.println("Low level selected.");
            case MEDIUM -> System.out.println("Medium level selected: Value=" + myLevel.getValue());
            case HIGH -> System.out.println("High level selected.");
        }

        // Iterating over all Enum values
        for (Level l : Level.values()) {
            System.out.println("Enum Const: " + l.name() + " | Index: " + l.ordinal());
        }
    }

    // =========================================================================
    // SECTION 4: KEY INTERVIEW QUESTIONS
    // =========================================================================

    /*
     * Q: Can we extend an Enum?
     * A: NO. Enums implicitly extend java.lang.Enum and Java doesn't support 
     *    multiple inheritance. Enums are also 'final' by default.
     * 
     * Q: Enum: == vs .equals()?
     * A: Both work safely! Since Enums are singletons in the JVM, 
     *    '==' is faster and Null-safe for Enum comparison.
     */
}
