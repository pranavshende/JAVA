package OOPS;

/**
 * 📘 TOPIC 1: INHERITANCE
 * Reusing code and building hierarchies.
 * Covers extends, super, and method overriding.
 */
public class Inheritance {

    // =========================================================================
    // SECTION 1: BASICS - Parent and Child
    // =========================================================================

    // Parent Class (Base)
    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void eat() {
            System.out.println(name + " is eating...");
        }

        public void makeSound() {
            System.out.println("Animal makes a generic sound.");
        }
    }

    // Child Class (Derived)
    // Q: What is the keyword for inheritance?
    // A: 'extends'. 
    static class Dog extends Animal {
        String breed;

        public Dog(String name, String breed) {
            // Q: What is the 'super' keyword?
            // A: It calls the constructor of the parent class. MUST be the first statement.
            super(name); 
            this.breed = breed;
        }

        // Q: What is Method Overriding?
        // A: Providing a specific implementation for a method already in the parent class.
        @Override
        public void makeSound() {
            System.out.println(name + " (the " + breed + ") is Barking!");
        }

        public void fetch() {
            System.out.println(name + " is fetching the ball.");
        }
    }

    // =========================================================================
    // SECTION 2: TYPES OF INHERITANCE
    // =========================================================================

    /*
     * 1. Single Inheritance: Class B extends A (Java supports).
     * 2. Multilevel Inheritance: Class C extends B extends A (Java supports).
     * 3. Hierarchical Inheritance: B and C both extend A (Java supports).
     * 4. Multiple Inheritance: B extends both A and D (Java DOES NOT support classes, but supports via INTERFACES).
     * 
     * Q: Why does Java not support multiple inheritance for classes?
     * A: To avoid the Diamond Problem (Ambiguity if two parents have the same method).
     */

    // =========================================================================
    // SECTION 3: KEYWORDS - super, this, and final
    // =========================================================================

    /*
     * super: Access parent members (super.eat(), super()).
     * this: Access current class members (this.name, this()).
     * final: 
     *      - final class: Cannot be extended (e.g., String class).
     *      - final method: Cannot be overridden.
     *      - final variable: Cannot be reassigned.
     */

    public void demonstrate() {
        Dog myDog = new Dog("Buddy", "Golden Retriever");
        myDog.eat();        // Inherited from Animal
        myDog.makeSound();  // Overridden in Dog
        myDog.fetch();      // Specific to Dog
    }
}
