package Operators;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 📘 TOPIC 3: OPERATORS
 * A complete practice and revision module covering arithmetic, relational, logical,
 * bitwise operators, precedence issues, and thread-safety.
 */
public class Operators {

    // =========================================================================
    // SECTION 1: BASICS - Types of Operators
    // =========================================================================

    public void basicOperators() {
        // 1. Arithmetic Operators
        int add = 10 + 5;
        int mod = 10 % 3; // Modulus (remainder)
        System.out.println("Basic Math: " + add + ", " + mod);

        // 2. Relational Operators (Compare values, return boolean)
        int testA = 10, testB = 5;
        boolean isEqual = (testA == 10);
        boolean isNotEqual = (testA != testB);
        System.out.println("Relational: " + isEqual + ", " + isNotEqual);

        // 3. Logical Operators (Combine boolean expressions)
        // && (Logical AND - short circuits), || (Logical OR - short circuits), ! (Logical NOT)
        boolean logic = (5 > 3) && (8 < 10);
        System.out.println("Logic AND: " + logic);
        
        // 4. Unary Operators
        int number = 10;
        number = -number; // negates
        
        // 5. Ternary Operator (Condition ? TrueResult : FalseResult)
        String res = (number > 0) ? "Positive" : "Negative";
        System.out.println("Ternary: " + res);
    }

    // =========================================================================
    // SECTION 2: ADVANCED & EDGE CASES
    // =========================================================================

    // Q: How does operator precedence affect expression evaluation?
    // A: Multiplication/Division occur before Addition/Subtraction.
    // It can cause logical bugs if not properly grouped with parenthesis.
    public void precedenceBugs() {
        int result = 10 + 5 * 2; // Output is 20, NOT 30!
        int correctResult = (10 + 5) * 2; // Output is 30.
        System.out.println("Result: " + result + " | Correct: " + correctResult);
        
        // Q: Suppose you have a complex condition in an if statement. How can precedence cause bugs?
        // A: '&&' has higher precedence than '||'. 
        // Example: a || b && c evaluates 'b && c' FIRST.
        boolean a = true, b = false, c = false;
        boolean bug = a || b && c; // True
        boolean intended = (a || b) && c; // False - USE PARENTHESES!
        System.out.println("Bug (Precedence): " + bug + " | Intended: " + intended);
    }

    // Q: Difference between pre-increment and post-increment?
    public void incrementDifferences() {
        int i = 5;
        // Post-increment (use original value, THEN increment)
        int a = i++; // a gets 5, i becomes 6
        
        int j = 5;
        // Pre-increment (increment FIRST, THEN use value)
        int b = ++j; // j becomes 6, b gets 6
        System.out.println("After Post: " + a + " | After Pre: " + b);
    }

    // =========================================================================
    // SECTION 3: COMMON STRINGS AND OBJECTS MISTAKE
    // =========================================================================

    // Q: A developer uses == to compare strings causing unexpected results. Fix?
    // A: '==' compares the memory references (Heap Address). 
    // '.equals()' compares the actual value or content.
    public void compareStrings() {
        String s1 = new String("Java");
        String s2 = new String("Java");
        
        System.out.println(s1 == s2);      // FALSE: Different objects in memory
        System.out.println(s1.equals(s2)); // TRUE: Same content
    }

    // =========================================================================
    // SECTION 4: MULTITHREADING AND INCREMENT
    // =========================================================================

    // Q: A thread-safe counter uses count++. Why is this not safe?
    // A: 'count++' involves 3 steps: Read, Add 1, Write back. Interleaving threads will cause lost updates.
    int unsafeCount = 0;
    AtomicInteger safeCount = new AtomicInteger(0);
    
    public void incrementSafely() {
        // BAD Practice in multithreading
        unsafeCount++;
        
        // GOOD Practice
        safeCount.incrementAndGet();
    }

    // =========================================================================
    // SECTION 5: BITWISE AND LOW-LATENCY
    // =========================================================================

    // Q: How do bitwise operators work internally, and why prefer them in low-latency apps?
    // A: They manipulate raw binary bits directly. For instance:
    //    << (left shift) multiplies by 2
    //    >> (right shift) divides by 2
    // CPU executes bitwise operations much faster than standard arithmetic divisions.
    public void bitwisePerformance() {
        int num = 16;
        int fastDivideByTwo = num >> 1; // Evaluates to 8
        int fastMultiplyByTwo = num << 1; // Evaluates to 32
        
        // Bitwise AND (&) to check odd/even is faster than Modulus (%)
        boolean isOdd = (num & 1) == 1; 
        System.out.println("Bitwise: /2=" + fastDivideByTwo + " *2=" + fastMultiplyByTwo + " Odd?" + isOdd);
    }

    // =========================================================================
    // SECTION 6: DISCOUNT PRECEDENCE CALCULATION
    // =========================================================================

    // Q: Write a formula for discount calculation avoiding precedence bugs.
    public void calculateDiscountSafe() {
        BigDecimal price = new BigDecimal("100.00");
        BigDecimal discountPercent = new BigDecimal("15.00");
        
        // Safe explicit calculation: (price * discountPercent) / 100
        BigDecimal discountAmount = price.multiply(discountPercent)
                                         .divide(new BigDecimal("100"));
        BigDecimal finalPrice = price.subtract(discountAmount);
        System.out.println("Final Price with Discount: " + finalPrice);
    }
}
