package DataTypes;

import java.util.Arrays;

/**
 * 📘 TOPIC 2.2: NON-PRIMITIVE DATA TYPES (REFERRED TYPES)
 * Non-primitives are objects created using 'new' (except for Strings/Arrays in some cases).
 * They represent complex models and reside on the HEAP, while references sit on the STACK.
 */
public class NonPrimitiveDataTypes {

    public void demonstrateObjects() {
        // --- 1. Strings ---
        // Strings are non-primitive objects. Java handles them specially via the String Pool.
        String name = "Pranav";
        String sameName = "Pranav"; // Points to the same object in pool

        // --- 2. Arrays ---
        // Arrays are non-primitive and have fixed sizes once initialized.
        int[] scoreBoard = {10, 25, 60, 95};
        
        // --- 3. Custom Objects (Classes) ---
        // Instances of any class are non-primitive objects.
        Object genericObj = new Object();
        System.out.println("Generic Object: " + genericObj);

        // Demonstration of Object nullability
        String nullableValue = null; // Primitives CANNOT be null, but Objects can.

        System.out.println("String Value: " + name + " (Reference same? " + (name == sameName) + ")");
        System.out.println("Array Content: " + Arrays.toString(scoreBoard));
        System.out.println("Nullable value check: " + nullableValue);
    }

    /*
     * INTERVIEW Q&A:
     * 1. Q: Primitive vs. Non-Primitive major differences?
     *    A: Size: Primitives have fixed size; Non-primitives depend on object complexity.
     *    A: Memory: Primitives reside on Stack; Non-primitives on Heap.
     *    A: Methods: Non-primitives have methods; primitives do not.
     *    A: Nullability: Only Non-primitives can be 'null'.
     *
     * 2. Q: Is a String a primitive?
     *    A: No, it is a class (java.lang.String) and thus non-primitive.
     */

    public static void main(String[] args) {
        new NonPrimitiveDataTypes().demonstrateObjects();
    }
}
