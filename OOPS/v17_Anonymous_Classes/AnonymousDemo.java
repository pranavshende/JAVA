package OOPS.v17_Anonymous_Classes;

/**
 * 📘 TOPIC: ANONYMOUS CLASSES AND LAMBDAS
 * 
 * 1. Anonymous Classes: Creating an implementation "on the fly" without a name.
 * 2. Lambdas: A shorter syntax for implementing functional interfaces.
 * 3. Functional Interface: An interface with exactly ONE abstract method.
 */

// [1] BASIC: Interface for Anonymous implementation
interface Greeter {
    void sayHello();
}

// [2] INTERMEDIATE: Abstract Class implementation via Anonymous Class
abstract class Shape {
    abstract void draw();
}

public class AnonymousDemo {
    public static void main(String[] args) {
        System.out.println("--- Anonymous Classes Demonstration ---");

        // [3] ADVANCED: Anonymous Implementation of an Interface
        Greeter englishGreeter = new Greeter() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Greeter!");
            }
        };

        // [4] INTERMEDIATE: Anonymous Implementation of an Abstract Class
        Shape anonymousCircle = new Shape() {
            @Override
            void draw() {
                System.out.println("Drawing an Anonymous Circle...");
            }
        };

        englishGreeter.sayHello();
        anonymousCircle.draw();

        // [5] MODERN JAVA: Lambda Expression
        // Q: Can we write Greeter with a Lambda?
        // A: YES! Since it's a functional interface.
        Greeter lambdaGreeter = () -> System.out.println("Hello from Lambda Greeter!");
        lambdaGreeter.sayHello();

        // [6] INTERVIEW FOCUS:
        // Q: Difference between Anonymous Class and Lambda?
        // A: Anonymous Class can implement classes/multiple methods. Lambda ONLY works for Functional Interfaces.
        
        // Q: "Variable Capture" in Anonymous Classes?
        // A: Local variables used in Anonymous classes MUST be final or "effectively final".
    }
}

/**
 * 💡 DRY RUN SUMMARY (Anonymous/Lambdas):
 * 1. JVM creates a temporary class file (e.g., AnonymousDemo$1.class) for the Greeter.
 * 2. It instantiates it and assigns it to 'englishGreeter'.
 * 3. Lambda 'lambdaGreeter' is more efficient; it's translated 
 *    into an 'invokedynamic' instruction at bytecode level.
 */
