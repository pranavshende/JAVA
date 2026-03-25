package OOPS.v05_Inheritance;

/**
 * 📘 TOPIC: INHERITANCE
 * 
 * 1. Single Inheritance: One subclass inherits from one superclass.
 * 2. Multilevel Inheritance: A class inherits from a subclass (Grandparent -> Parent -> Child).
 * 3. Hierarchical Inheritance: Multiple subclasses inherit from a single superclass.
 * 4. Hybrid/Multiple Inheritance: Not supported via classes to avoid the "Diamond Problem".
 */

// [1] BASIC: Parent Class
class Animal {
    String name;

    Animal(String name) { this.name = name; }

    void sleep() {
        System.out.println(name + " is sleeping...");
    }

    void eat() {
        System.out.println(name + " is eating...");
    }
}

// [2] INTERMEDIATE: Single Inheritance
class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name); // Call parent constructor
        this.breed = breed;
    }

    void bark() {
        System.out.println(name + " (" + breed + ") is barking: Woof! Woof!");
    }
}

// [3] ADVANCED: Multilevel Inheritance
class Labrador extends Dog {
    Labrador(String name) {
        super(name, "Labrador");
    }

    void playFetch() {
        System.out.println(name + " loves playing fetch!");
    }
}

// [4] HIERARCHICAL INHERITANCE: Multiple children from same parent
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    void meow() {
        System.out.println(name + " says: Meow!");
    }
}

/**
 * INTERVIEW FOCUS: Multiple inheritance?
 * 
 * Q: Why doesn't Java support multiple inheritance with classes?
 * A: To avoid ambiguity (Diamond Problem). If Class A has method M(), and Class B has method M(), 
 * and Class C extends both A and B, which M() should C inherit? 
 * Java solves this by using INTERFACES instead!
 */

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("--- Single Inheritance ---");
        Dog myDog = new Dog("Buddy", "Golden Retriever");
        myDog.eat(); // Inherited from Animal
        myDog.bark(); // Specific to Dog

        System.out.println("\n--- Multilevel Inheritance ---");
        Labrador lab = new Labrador("Leo");
        lab.eat(); // Inherited from Animal
        lab.bark(); // Inherited from Dog
        lab.playFetch(); // Specific to Labrador

        System.out.println("\n--- Hierarchical Inheritance ---");
        Cat myCat = new Cat("Whiskers");
        myCat.eat(); // Inherited from same parent (Animal)
        myCat.meow(); // Specific to Cat

        // [5] INCORRECT USAGE:
        // Dog d = new Animal("Generic Animal"); // COMPILE ERROR: Child cannot be parent.
        
        // Correct Polymorphic Usage:
        Animal polyDog = new Dog("Max", "Street Dog");
        polyDog.eat(); // OK
        // polyDog.bark(); // COMPILE ERROR: Animal reference doesn't know about Dog-specific methods.
    }
}

/**
 * 💡 DRY RUN EXPLANATION:
 * 1. For Labrador "Leo":
 *    - Labrador constructor calls super("Leo", "Labrador").
 *    - Dog constructor calls super("Leo").
 *    - Animal constructor sets name = "Leo".
 * 2. lab.eat() searches Labrador class -> Not found.
 * 3. lab.eat() searches Dog class -> Not found.
 * 4. lab.eat() searches Animal class -> Found and Executed!
 */
