package ModernJava;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 📘 TOPIC 6: JAVA 8+ MODERN FEATURES
 * Shifting towards functional style in Java.
 * Covers Lambda Expressions, Streams API, and Optional.
 */
public class ModernJava {

    // =========================================================================
    // SECTION 1: LAMBDA EXPRESSIONS (Functional Style)
    // =========================================================================

    // Q: What is a Lambda Expression?
    // A: An anonymous function (a method without a name). 
    // It enables treating a functional interface (interface with one abstract method) 
    // as a first-class citizen.
    public void demonstrateLambdas() {
        System.out.println("--- 1. Lambda Expressions ---");

        // Old way (Anonymous inner class)
        new Thread(new Runnable() {
            @Override
            public void run() { System.out.println("Old method running..."); }
        }).start();

        // New way (Lambda)
        new Thread(() -> System.out.println("Lambda method running...")).start();
    }

    // =========================================================================
    // SECTION 2: FUNCTIONAL INTERFACES (Standard APIs)
    // =========================================================================

    /*
     * 1. Predicate: Input T -> Returns Boolean (test()).
     * 2. Function: Input T -> Returns R (apply()).
     * 3. Consumer: Input T -> Returns Void (accept()).
     * 4. Supplier: No Input -> Returns Result T (get()).
     */
    public void demonstrateFunctionalInterfaces() {
        System.out.println("--- 2. Functional Interfaces ---");
        
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("10 is even? " + isEven.test(10));

        Consumer<String> logger = System.out::println; // Method Reference
        logger.accept("Logging message...");
    }

    // =========================================================================
    // SECTION 3: STREAMS API (Data Processing Pipeline)
    // =========================================================================

    // Q: What is a Stream in Java?
    // A: A sequence of elements supporting sequential and parallel aggregate operations.
    // It DOES NOT store data; it conveys data from a source (Collection/Array).
    public void demonstrateStreams() {
        System.out.println("--- 3. Streams API ---");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave", "Eve");

        // Pipeline: filter -> map -> sorted -> collect
        List<String> results = names.stream()
            .filter(n -> n.length() > 3)        // Filter long names
            .map(String::toUpperCase)           // Convert to UpperCase
            .sorted()                           // Alphabetical order
            .collect(Collectors.toList());      // Terminate and collect result

        System.out.println("Result names: " + results);

        // IntStream operations
        int sumOfEvens = Stream.of(1, 2, 3, 4, 5, 6)
            .filter(n -> n % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("Sum of evens: " + sumOfEvens);
    }

    // =========================================================================
    // SECTION 4: OPTIONAL CLASS (Null-Safety)
    // =========================================================================

    // Q: Why use Optional?
    // A: To represent a value that may or may not be present, 
    // forcing the developer to handle the null case explicitly and safely.
    public void demonstrateOptional(String input) {
        System.out.println("--- 4. Optional Class ---");
        Optional<String> maybeData = Optional.ofNullable(input);

        // Safe handling
        String result = maybeData.orElse("Default Value");
        System.out.println("Processed: " + result);

        // Functional approach
        maybeData.ifPresent(d -> System.out.println("Value exists: " + d));
    }

    // =========================================================================
    // SECTION 5: METHOD REFERENCES (::)
    // =========================================================================

    /*
     * Q: What is a Method Reference?
     * A: A shorthand for a lambda expression that only calls an existing method.
     * System.out::println  is equivalent to  s -> System.out.println(s)
     */

    // =========================================================================
    // SECTION 6: DATE & TIME API (LocalTime, LocalDate)
    // =========================================================================

    /*
     * Q: Why was java.util.Date replaced in Java 8?
     * A: It was mutable, confusing month indexing (0-11), and not thread-safe.
     * New classes (LocalDate, LocalTime, ZonedDateTime) are immutable and clearer.
     */

    // =========================================================================
    // SECTION 7: JAVA 14+ RECORDS (Immutability Made Easy)
    // =========================================================================

    // Q: What is a Record?
    // A: A special type of class designed to hold immutable data. 
    // It automatically generates the constructor, getters (name(), not getName()), 
    // equals(), hashCode(), and toString().
    public record User(String name, int age) {}

    public void demonstrateRecords() {
        System.out.println("--- 7. Records (Java 14+) ---");
        User user = new User("Alice", 30);
        System.out.println("User record: " + user.name() + " is " + user.age());
        // user.name = "Bob"; // COMPILE ERROR: Records are final and fields are final.
    }

    // =========================================================================
    // SECTION 8: JAVA 15+ SEALED CLASSES (Hierarchy Control)
    // =========================================================================

    // Q: Why use Sealed Classes?
    // A: To restrict which classes can extend or implement them. 
    // Useful for modeling domain logic (e.g., only certain types of accounts).
    public sealed interface Payment permits CreditCard, PayPal {}

    public final class CreditCard implements Payment {}
    public final class PayPal implements Payment {}

    // =========================================================================
    // SECTION 9: JAVA 15+ TEXT BLOCKS (Multiline Strings)
    // =========================================================================

    public void demonstrateTextBlocks() {
        System.out.println("--- 9. Text Blocks (Java 15+) ---");
        // Q: Benefit over standard strings?
        // A: No need for manual escape sequences (\n, \") for multiline strings.
        String json = """
                {
                    "name": "JavaMaster",
                    "version": 17,
                    "status": "Awesome"
                }
                """;
        System.out.println(json);
    }
}

