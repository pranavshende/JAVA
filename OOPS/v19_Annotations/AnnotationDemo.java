package OOPS.v19_Annotations;

import java.lang.annotation.*;

/**
 * 📘 TOPIC: ANNOTATIONS
 * 
 * 1. Annotation: Metadata (information) about a part of the program.
 * 2. Built-in: @Override, @Deprecated, @SuppressWarnings.
 * 3. Custom: Can be defined using @interface.
 * 4. RetentionPolicy: SOURCE, CLASS, or RUNTIME.
 */

// [1] ADVANCED: Creating a Custom Annotation
// Retention: How long is the annotation kept? (RUNTIME means we can read it via Reflection).
// Target: Where can we apply this? (METHOD, TYPE, etc.)

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface FastExecution {
    String value() default "No Tag";
    int timeLimit() default 1000; // in milliseconds
}

class Processor {
    @Override // Built-in: Check if method is overriding correctly.
    public String toString() { return "Processor Object"; }

    @Deprecated // Built-in: Mark method as old/outdated.
    void oldLoadFile() {
        System.out.println("Loading file (using legacy code)...");
    }

    // [2] INTERMEDIATE: Using Custom Annotation
    @FastExecution(value = "Critical", timeLimit = 500)
    void processData() {
        System.out.println("Processing data (Fast Execution Requested)...");
    }
}

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Built-in Annotations ---");
        Processor p = new Processor();
        System.out.println(p); // toString() override called
        p.oldLoadFile(); // Warning (deprecated)
        
        System.out.println("\n--- Reflection and Custom Annotations ---");
        // Reflection is used to read annotations at runtime.
        java.lang.reflect.Method m = p.getClass().getDeclaredMethod("processData");
        
        if (m.isAnnotationPresent(FastExecution.class)) {
            FastExecution ann = m.getAnnotation(FastExecution.class);
            System.out.println("Tag: " + ann.value());
            System.out.println("Time Limit Allowed: " + ann.timeLimit() + "ms");
            
            p.processData();
        }

        // [3] INTERVIEW FOCUS:
        // Q: What exactly are annotations? 
        // A: They don't change program logic directly, but tools/frameworks (Spring, JUnit) read 
        // them to behave differently.
        
        // Q: Difference between @Override and not using it?
        // A: Without @Override, if you mistype a method name, it becomes a NEW method instead of an OVERRIDE!
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. Processor class is compiled with @Deprecated and @FastExecution annotations.
 * 2. At runtime, AnnotationDemo uses 'getClass().getDeclaredMethod()' to get metadata.
 * 3. 'isAnnotationPresent' checks if @FastExecution was used.
 * 4. If yes, it retrieves values (value="Critical", timeLimit=500) and prints them.
 */
