package Advanced;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.regex.*;

/**
 * 📘 TOPIC 11: MISC ADVANCED TOPICS
 * Reflection, Annotations, and Regular Expressions (Regex).
 * For building frameworks and dynamic applications.
 */
public class AdvancedTopics {

    // =========================================================================
    // SECTION 1: REFLECTION (Introspection)
    // =========================================================================

    // Q: What is Reflection API?
    // A: Examining or modifying the structure (fields, methods) of a class at RUNTIME.
    // Extremely powerful but can be slow and break encapsulation.
    public void demonstrateReflection() {
        System.out.println("--- 1. Reflection ---");
        try {
            Class<?> clazz = Class.forName("Classes.ClassesModule$Student");
            
            // Getting Class metadata
            System.out.println("Class simple name: " + clazz.getSimpleName());
            
            // Getting ALL methods (including inherited)
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                if (m.getName().equals("display")) {
                    System.out.println("Found 'display' method via Reflection.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Reflection failed: " + e.getMessage());
        }
    }

    // =========================================================================
    // SECTION 2: ANNOTATIONS (Metadata)
    // =========================================================================

    // Q: What are Annotations?
    // A: Metadata tags that provide information for the compiler or runtime.
    // Example: @Override, @Deprecated, @SuppressWarnings.
    
    // Creating a Custom Annotation
    @Retention(RetentionPolicy.RUNTIME) // Available at runtime
    @Target(ElementType.METHOD)        // Only for methods
    public @interface InterviewMark {
        String topic() default "General";
        int importance() default 5;
    }

    @InterviewMark(topic = "OOPS", importance = 10)
    public void keyTopicMethod() {
        System.out.println("--- 2. Custom Annotations ---");
        System.out.println("This method is marked as critical for interviews.");
    }

    // =========================================================================
    // SECTION 3: REGULAR EXPRESSIONS (Regex)
    // =========================================================================

    // Q: How to validate an Email format using Regex?
    // A: Pattern and Matcher classes in 'java.util.regex'.
    public boolean validateEmail(String email) {
        System.out.println("--- 3. Regex ---");
        
        // Simplified email regex example
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        boolean isValid = matcher.matches();
        System.out.println("Email '" + email + "' is valid: " + isValid);
        return isValid;
    }

    // =========================================================================
    // SECTION 4: INTERVIEW PITFALLS
    // =========================================================================

    /*
     * Q: Reflection: Why is it slow?
     * A: JVM cannot perform standard optimizations (JIT inlining). 
     *    Type matching is done at runtime, not compile-time.
     * 
     * Q: Annotations: Does @Override have a functional impact?
     * A: NO. It's only for the compiler-check to ensure you properly 
     *    overrode a parent method. It's excellent for preventing bugs.
     */
}
