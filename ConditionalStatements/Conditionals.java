package ConditionalStatements;

/**
 * 📘 TOPIC: CONDITIONAL STATEMENTS
 * A complete practice and revision module covering if-else, switch, ternary,
 * short-circuiting, and performance considerations.
 */
public class Conditionals {

    // =========================================================================
    // SECTION 1: IF - ELSE IF - ELSE
    // =========================================================================

    public void basicIfElse(int age) {
        // Q: Basic if-else logic
        if (age < 0) {
            System.out.println("Invalid age.");
        } else if (age < 18) {
            System.out.println("Underage (Minor)");
        } else if (age >= 18 && age < 65) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior Citizen");
        }
    }

    // =========================================================================
    // SECTION 2: SWITCH STATEMENT (TRADITIONAL)
    // =========================================================================

    // Q: Difference between if-else and switch?
    // A: Switch is faster for many constant-value comparisons (uses jump tables).
    // Traditional Switch has "fall-through" behavior if 'break' is omitted.
    public void traditionalSwitch(int day) {
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
            case 7: System.out.println("Sunday"); break;
            default: System.out.println("Invalid Day");
        }
    }

    // =========================================================================
    // SECTION 3: JAVA 14+ ENHANCED SWITCH (SWITCH EXPRESSIONS)
    // =========================================================================

    // Q: What is the benefit of the new Switch Expression?
    // A: No break needed (no fall-through), can return a value directly, and cleaner syntax.
    public String enhancedSwitchExpr(String country) {
        return switch (country) {
            case "India" -> "New Delhi";
            case "USA" -> "Washington D.C.";
            case "UK", "London" -> "London"; // Multiple cases on one line
            default -> "Unknown Capital";
        };
    }

    // =========================================================================
    // SECTION 4: SHORT-CIRCUIT EVALUATION & PITFALLS
    // =========================================================================

    // Q: Why is the order of conditions important?
    // A: && and || use short-circuiting. If the first part of && is false, 
    // the second part is NEVER evaluated. This saves performance and prevents NPEs.
    public void shortCircuitPitfall(String text) {
        // SAFE: Check for null first. If null, short-circuit prevents NPE in .isEmpty()
        if (text != null && !text.isEmpty()) {
            System.out.println("Valid text: " + text);
        } else {
            System.out.println("Null or empty text.");
        }

        // UNSAFE: Calling a method on a potentially null object first.
        // if (!text.isEmpty() && text != null) { ... } -> THROWS NullPointerException!
    }

    // =========================================================================
    // SECTION 5: TERNARY OPERATOR & EDGE CASES
    // =========================================================================

    // Q: When to use ternary over if-else?
    // A: Use ternary for concise, single-line assignments only. Excessive nesting makes code unreadable.
    public void ternaryExample(int score) {
        String result = (score >= 40) ? "PASS" : "FAIL";
        System.out.println("Student Status: " + result);
        
        // NESTED TERNARY (BAD Practice for readability):
        // String grade = (score > 90) ? "A" : (score > 80) ? "B" : "C"; 
    }

    // =========================================================================
    // SECTION 6: INTERVIEW PROBLEMS & PERFORMANCE
    // =========================================================================

    // Q: How to find the largest of three numbers efficiently?
    public int findLargest(int a, int b, int c) {
        if (a >= b && a >= c) return a;
        if (b >= a && b >= c) return b;
        return c;
    }

    // Q: Performance switch vs if-else?
    /*
     * A: 'if-else' is O(N) linear search (worst case checks all). 
     * 'switch' (when compiled with tableswitch) is O(1) jump table lookup.
     * Compiler chooses between tableswitch (dense values) or lookupswitch (sparse values).
     */
}
