package TypeCasting;

import java.util.ArrayList;
import java.util.List;

/**
 * 📘 TOPIC 4: TYPECASTING
 * A complete practice and revision module covering widening, narrowing, 
 * downcasting hazards, generics, and real-world safe casting patterns.
 */
public class TypeCasting {

    // =========================================================================
    // SECTION 1: BASICS - Primitive Typecasting
    // =========================================================================

    // Q: What is the difference between widening and narrowing casting?
    // A: Widening (Implicit): Converting a smaller type to a larger type automatically. Safe.
    // A: Narrowing (Explicit): Converting a larger type to a smaller type manually. Unsafe (data loss).
    
    public void primitiveCasting() {
        // 1. Widening (Implicit Casting)
        int myInt = 100;
        long myLong = myInt; // Safe, int fits inside long
        double myDouble = myInt; // Automatic cast to double (100.0)

        // 2. Narrowing (Explicit Casting)
        double largeDecimal = 9.78;
        int truncatedInt = (int) largeDecimal; // Drops decimal, becomes 9
        System.out.println("Narrowing: " + largeDecimal + " -> " + truncatedInt);
        System.out.println("Widening: " + myLong + ", " + myDouble);
    }

    // Q: How does Java handle implicit casting between primitives?
    // A: In an expression with mixed primitive types, Java automatically promotes smaller 
    // variables to the largest type in the expression (e.g., int + double = double).
    public void implicitPromotion() {
        int a = 10;
        double b = 5.5;
        double result = a + b; // 'a' is implicitly cast to double before addition
        System.out.println("Implicit promotion result: " + result);
    }

    // =========================================================================
    // SECTION 2: OBJECT TYPECASTING & CLASSSCASTEXCEPTION
    // =========================================================================

    class Employee { String name; }
    class Manager extends Employee { int teamSize; }

    // Q: Why can downcasting cause ClassCastException? (Important)
    // A: Downcasting forces a Parent reference to act as a Child. If the object isn't ACTUALLY 
    // an instance of the Child class at runtime, Java throws a ClassCastException.
    public void downcastHazard() {
        Employee emp = new Employee(); // ACTUAL object is Employee
        
        try {
            // DANGEROUS DOWNCAST: The object is NOT a Manager!
            Manager mgr = (Manager) emp; // Throws ClassCastException
            System.out.println("Line not reached, but mgr is: " + mgr);
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: Cannot treat Employee as Manager!");
        }
        
        // SAFE DOWNCAST (Using instanceof)
        if (emp instanceof Manager) {
            Manager safeMgr = (Manager) emp; 
            System.out.println("Safe downcast: " + safeMgr);
            // In Java 16+ Pattern Matching: if (emp instanceof Manager safeMgr) { ... }
        }
    }

    // =========================================================================
    // SECTION 3: GENERICS & COLLECTIONS
    // =========================================================================

    // Q: How do generics help reduce casting issues?
    // A: Before generics (Java 5), Collections stored Objects which required manual casting upon retrieval.
    // Generics enforce compile-time type safety and automatically handle downcasting.
    public void genericsAdvantage() {
        // Without Generics (Requires Casting - Parameterized to List<Object> for safety)
        List<Object> legacyList = new ArrayList<>();
        legacyList.add("StringData");
        String s = (String) legacyList.get(0); // Annoying!
        
        // With Generics (No Casting)
        List<String> genericList = new ArrayList<>();
        genericList.add("StringData");
        String safeStr = genericList.get(0); 
        System.out.println("Legacy retrieval: " + s + " | Generic retrieval: " + safeStr);
    }

    // Q: A legacy API returns a List<Object>. Convert it safely to List<Employee>?
    public List<Employee> convertLegacyList(List<Object> legacyApiData) {
        List<Employee> safeList = new ArrayList<>();
        for (Object obj : legacyApiData) {
            // Safely filter and cast
            if (obj instanceof Employee) {
                safeList.add((Employee) obj);
            }
        }
        return safeList;
    }

    // =========================================================================
    // SECTION 4: REAL-WORLD EDGE CASES
    // =========================================================================

    // Q: JSON parser returning an Object. How to safely cast to the desired type?
    // A: Avoid blinded direct casting. Map it utilizing 'instanceof', or better, 
    // use a typed serialization library like Jackson ObjectMapper.
    public void handleJsonObject(Object jsonParsedData) {
        if (jsonParsedData instanceof String strData) { // Java 16+ feature
            System.out.println("It's a string: " + strData.toUpperCase());
        }
    }

    // Q: Large dataset uses double, but precision is lost when casting into int. Redesign?
    // A: A double easily exceeds 'int' max bound, causing it to truncate or overflow.
    // Redesign: Don't cast. Use 'long' for very large numbers or 'Math.round()' / 'Math.floor()' strictly.
    public void handleLargeDataset(double largeVal) {
        // int brokenVal = (int) largeVal; // Overflows or loses fractional data
        long roundedVal = Math.round(largeVal);
        System.out.println("Rounded double: " + roundedVal);
    }

    // Q: Application receives numeric input as a string. How do you safely convert it without crashing?
    // A: Use 'Integer.parseInt' wrapped with a try-catch for NumberFormatException.
    public int safeParseInput(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.err.println("Invalid numeric string: " + userInput);
            return 0; // Or throw custom application exception
        }
    }
}
