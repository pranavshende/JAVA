package OOPS.v15_Object_Class_Methods;

import java.util.Objects;

/**
 * 📘 TOPIC: OBJECT CLASS METHODS
 * 
 * 1. toString(): Returns a string representation of the object.
 * 2. equals(): Compares two objects for equality based on their content.
 * 3. hashCode(): Returns an integer representation (hash) of the object.
 * 4. clone(): Creates a copy of the object (Requires Cloneable interface).
 */

class Product implements Cloneable {
    int id;
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // [1] BASIC: toString() - Making object readable
    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + "]";
    }

    // [2] INTERMEDIATE: equals() and hashCode()
    // Always override both if you override one!
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // check if same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Product product = (Product) obj;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // [3] ADVANCED: clone() - Shallow cloning example
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectMethodsDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(101, "Laptop");
        Product p3 = p1; // Same reference as p1

        System.out.println("--- toString() ---");
        System.out.println("p1.toString(): " + p1);

        System.out.println("\n--- equals() vs == operator ---");
        System.out.println("p1 == p2: " + (p1 == p2)); // false (Different memory locations)
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true (Same content)
        System.out.println("p1 == p3: " + (p1 == p3)); // true (Same reference)

        System.out.println("\n--- hashCode() ---");
        System.out.println("p1 Hash: " + p1.hashCode());
        System.out.println("p2 Hash: " + p2.hashCode()); // Should be same as p1 if equals() is true

        System.out.println("\n--- clone() ---");
        Product p_clone = (Product) p1.clone();
        System.out.println("Cloned Product: " + p_clone);
        System.out.println("p1 == p_clone: " + (p1 == p_clone)); // false

        // [4] INTERVIEW FOCUS:
        // Why override hashCode() with equals()?
        // If two objects are equal by equals(), they MUST have the same hashCode().
        // If not, Hash-based collections (HashMap, HashSet) will fail!
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Object Methods):
 * 1. p1 and p2 have identical content.
 * 2. Default Object.equals() compares references (returns false for p1/p2).
 * 3. Our overridden equals() compares id and name (returns true for p1/p2).
 * 4. Objects.hash() generates code based on values, ensuring identical hashCodes for identical content.
 */
