package DataTypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 📘 TOPIC 2: DATATYPES
 * A complete practice and revision module covering primitives, wrappers, 
 * memory allocation, performance, and best practices.
 */
public class DataTypes {

    // =========================================================================
    // SECTION 1: BASICS - Primitives and Objects
    // =========================================================================

    // Java has 8 Primitive Data Types:
    byte b = 127;           // 1 byte (8 bits): -128 to 127
    short s = 32_767;       // 2 bytes (16 bits)
    int i = 2_147_483_647;  // 4 bytes (32 bits) - Default choice for integers
    long l = 10L;           // 8 bytes (64 bits) - Suffix 'L' required if out of int range
    
    float f = 10.5f;        // 4 bytes (32 bits) - Suffix 'f' required
    double d = 20.99;       // 8 bytes (64 bits) - Default choice for decimals
    
    char c = 'A';           // 2 bytes (16 bits) - Unicode character
    boolean bool = true;    // Size JVM dependent (usually 1 bit mapped to 1 byte)

    // Q: How does Java handle memory allocation for primitives and objects?
    // A: Local primitives are allocated on the Thread Stack. 
    // Objects (and arrays, strings) are dynamically allocated on the Heap.
    // The reference (pointer) to the object is maintained on the Stack.

    // =========================================================================
    // SECTION 2: AUTOBOXING, UNBOXING & WRAPPER CLASSES
    // =========================================================================

    // Wrapper Classes convert primitives into Objects (e.g., int -> Integer).
    
    // Q: What is autoboxing and unboxing, and what performance issues can it cause?
    // A: Autoboxing is the automatic conversion of a primitive to its Wrapper class.
    // Unboxing is the reverse.
    
    public void autoboxingPerformancePitfall() {
        // PERFORMANCE ISSUE: Here, autoboxing creates a new Long object for every loop iteration!
        Long sum = 0L; // Autoboxing 0 to Long
        for(long n = 1; n < 10000; n++) {
            sum += n; // Unboxes 'sum', adds 'n', then AUTOBOXES the result to a new Long on Heap.
        }
        
        // FIX: Use primitive 'long' for math-heavy loops to avoid GC overhead and memory fragmentation.
        long primitiveSum = 0L;
        for(long n = 1; n < 10000; n++) {
            primitiveSum += n; 
        }
        System.out.println("Primitive sum: " + primitiveSum);
    }

    // =========================================================================
    // SECTION 3: REAL-WORLD USE CASES & EDGE CASES
    // =========================================================================

    // Q: What is the significance of 'var' in Java 10+?
    // A: 'var' is used for Local Variable Type Inference. The compiler infers the type.
    // It reduces boilerplate code but CANNOT be used for instance variables or without initialization.
    public void useVarKeyword() {
        var names = new ArrayList<String>(); // Compiler infers ArrayList<String>
        var count = 10;                      // Compiler infers int
        System.out.println("Var Inference: " + names.getClass().getSimpleName() + ", count=" + count);
    }

    // Q: Millions of numeric ops per second: Which data type to use (int, long, BigInteger)?
    // A: Use 'int' or 'long' for high-performance math since they are hardware-level CPU operations.
    // Use 'BigInteger' ONLY if values exceed the maximum capacity of a 64-bit 'long'.
    public void numericOperations() {
        long highlyPerformantNumber = Long.MAX_VALUE;
        BigInteger slowArbitraryPrecision = BigInteger.valueOf(highlyPerformantNumber).add(BigInteger.ONE);
        System.out.println("BigInteger Result: " + slowArbitraryPrecision);
        
        BigDecimal slowArbitraryPrecision2 = new BigDecimal("0.333");
        System.out.println("BigDecimal val: " + slowArbitraryPrecision2);
    }

    // Q: REST API returns null for some values causing NullPointerException. How to use wrapper types safely?
    // A: If a database column or JSON field can be null, ALWAYS use the Wrapper class (e.g., Integer) 
    // instead of the primitive (int). Then perform explicit null checks to avoid NPE during unboxing.
    public void safeNullHandling(Integer apiResponseCount) {
        // int unsafeCount = apiResponseCount; // DANGER: Unboxing a null Integer throws NullPointerException!
        
        // FIX:
        int safeCount = (apiResponseCount != null) ? apiResponseCount : 0;
        System.out.println("Safe count: " + safeCount);
    }

    // Q: Financial app using float shows rounding errors. Which datatype should be used instead?
    // A: 'float' and 'double' use binary floating-point representation, which cannot accurately
    // represent base-10 fractions (like 0.1). For finance/currency, ALWAYS use 'BigDecimal'.
    public void financeRoundingError() {
        System.out.println("Float Error: " + (0.1f + 0.2f)); // Output: 0.30000001
        
        // FIX: Use String constructors for BigDecimal to avoid binary precision loss
        BigDecimal val1 = new BigDecimal("0.1");
        BigDecimal val2 = new BigDecimal("0.2");
        System.out.println("Accurate Currency: " + val1.add(val2)); // Output: 0.3
    }

    // Added by user
    public void integerCacheBug() {
        Integer a = 127;
        Integer b = 127;
        System.out.println("127 == 127? " + (a == b)); // True (Cached)

        Integer c = 128;
        Integer d = 128;
        System.out.println("128 == 128? " + (c == d)); // False (Not cached!)

        // Safe comparison
        boolean safeComparisonResult = a.equals(b); // Renamed to avoid conflict with safeCount in safeNullHandling
        System.out.println("Safe comparison: " + safeComparisonResult);
    }

    // =========================================================================
    // SECTION 4: DESIGN CHOICES
    // =========================================================================

    // Q: Suppose you need to store employee data (name, id, salary). Which datatype/classes?
    // A: String (name), int/long (id), BigDecimal (salary, because money).
        class Employee {
            String name;
            long id;
            BigDecimal salary;
            
            public Employee(String name, long id, BigDecimal salary) {
                this.name = name; this.id = id; this.salary = salary;
            }

            public void printDetails() {
                String[] teamNames = {"Alice", "Bob"};
                int totalTeam = teamNames.length;
                System.out.println("Employee: " + name + " (Team Size: " + totalTeam + ")");
            }
        }

    // Q: A junior developer uses List<Object> for mixed-type data. What problems occur? Redesign?
    // A: Problems: No compile-time type safety. High risk of ClassCastException. Needs dirty "instanceof" checks.
    public void objectListProblems() {
        // BAD Practice
        List<Object> mixedList = new ArrayList<>();
        mixedList.add("John");
        mixedList.add(100);
        
        // String name = (String) mixedList.get(1); // RUNTIME ERROR: ClassCastException
        
        // GOOD Redesign: Use Generic classes for strict type safety.
        List<Employee> safeList = new ArrayList<>();
        safeList.add(new Employee("John", 100, new BigDecimal("50000")));
    }
}
