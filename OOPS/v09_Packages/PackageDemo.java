package OOPS.v09_Packages;

/**
 * 📘 TOPIC: PACKAGES
 * 
 * 1. Package: A container that groups related classes, interfaces, and sub-packages.
 * 2. Benefits: 
 *    - Avoids name conflicts (e.g. OOPS.Basics.Intro vs OOPS.Packages.Intro).
 *    - Better organization and access control.
 * 3. Import: Using 'import' to access classes from other packages.
 */

/*
 * INTERMEDIATE: Custom Package Example
 *
 * To run this correctly, Java files should be in a folder named 'OOPS/Packages/'.
 * Compilation: javac -d . PackageDemo.java
 * Execution: java OOPS.Packages.PackageDemo
 */

public class PackageDemo {
    public void displayMessage() {
        System.out.println("Message from OOPS.Packages.PackageDemo class!");
    }

    public static void main(String[] args) {
        System.out.println("--- Package Demonstration ---");
        PackageDemo demo = new PackageDemo();
        demo.displayMessage();

        // [1] ADVANCED: Built-in packages
        // java.lang: Default package (String, System, Math)
        // java.util: (ArrayList, HashMap, Date)
        // java.io:   (File, Reader, Writer)

        System.out.println("\n--- Accessing Classes from Other Packages ---");
        // We use fully qualified names or imports.
        // import OOPS.Classes_Objects.ClassesAndObjectsDemo;
        
        System.out.println("Use 'import package.ClassName;' to use other classes.");
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. 'package OOPS.Packages' tells the compiler this class belongs to the 'OOPS' and 'Packages' folders.
 * 2. Classes in the same package can access each other without importing.
 * 3. Classes in different packages must be 'public' to be accessible.
 */
