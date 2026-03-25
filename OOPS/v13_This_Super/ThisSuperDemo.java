package OOPS.v13_This_Super;

/**
 * 📘 TOPIC: THIS AND SUPER
 * 
 * 1. this: Refers to the current class instance.
 * 2. super: Refers to the parent class instance.
 * 
 * Both can be used to call fields, methods, AND constructors.
 */

// Parent Class
class Parent {
    String name = "Parent Class Field";

    Parent() {
        System.out.println("Parent: Calling Default Constructor.");
    }

    Parent(String name) {
        this.name = name;
        System.out.println("Parent: Initialized with name: " + name);
    }

    void display() {
        System.out.println("This is a method of Parent class.");
    }
}

// Child Class
class Child extends Parent {
    String name = "Child Class Field";

    // [1] BASIC: super() constructor call
    Child() {
        super("Base Parent"); // Calls Parent(String name) constructor
        System.out.println("Child: Calling Default Constructor.");
    }

    // [2] INTERMEDIATE: this() and super() field/method calls
    void showNames() {
        System.out.println("Child's name field: " + this.name);
        System.out.println("Parent's name field (via super): " + super.name);

        this.display(); // Calls Child's display (if overridden) or Parent's display
        super.display(); // Explicitly calls Parent's display
    }

    @Override
    void display() {
        System.out.println("This is the overridden method in Child class.");
    }

    // [3] ADVANCED: this() constructor chaining
    Child(String name) {
        this(); // Calls Child's default constructor
        this.name = name;
        System.out.println("Child: Initialized with name: " + name);
    }
}

public class ThisSuperDemo {
    public static void main(String[] args) {
        System.out.println("--- Child Object Creation ---");
        Child c1 = new Child("Custom Child");

        System.out.println("\n--- this vs super demo ---");
        c1.showNames();

        // [4] INTERVIEW FOCUS:
        // Q: Can this() and super() be in the same constructor?
        // A: NO. Both must be the FIRST statement. You can only use one!
        
        // Q: What happens if you don't call super()?
        // A: JVM automatically inserts super() [no-arg] if no call is made.
    }
}

/**
 * 💡 DRY RUN EXPLANATION (This vs Super):
 * 1. Child("Custom Child") -> this() -> Child() -> super("Base Parent") -> Parent("Base Parent").
 * 2. Parent constructor runs. Sets name = "Base Parent".
 * 3. Child() constructor runs.
 * 4. Child("Custom Child") finishes. Sets name = "Custom Child".
 * 5. result: this.name = "Custom Child", super.name = "Base Parent".
 */
