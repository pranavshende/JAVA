import Variables.Variables;
import DataTypes.DataTypes;
import Operators.Operators;
import TypeCasting.TypeCasting;
import Syntax.Syntax;
import ConditionalStatements.Conditionals;
import Arrays.ArraysModule;
import ExceptionHandling.ExceptionModule;
import WrapperClasses.WrapperModule;
import Vector.VectorModule;
import Output.OutputModule;
import Classes.ClassesModule;

// NEW MODULES
import Loops.LoopsModule;
import Strings.StringsModule;
import OOPS.Inheritance;
import OOPS.Polymorphism;
import OOPS.Abstraction;
import Collections.CollectionsModule;
import Concurrency.Multithreading;
import ModernJava.ModernJava;
import FileIO.FileModule;
import Advanced.AdvancedBasics;
import Advanced.AdvancedTopics;
import Generics.GenericsModule;
import Methods.MethodsModule;
import Database.JDBCModule;
import Performance.JVMModule;

/**
 * 📘 COMPREHENSIVE JAVA TEST RUNNER
 * Demonstrates the full topic-wise repository.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("🚀 JAVA MASTER PRACTICE REPOSITORY INITIALIZED");
        System.out.println("      Topics: Basics to Advanced JVM Internals");
        System.out.println("====================================================\n");

        // --- BASICS ---
        new Syntax().demonstration();
        new Variables().demonstrateLocalVariables();
        new DataTypes().financeRoundingError();
        new Operators().compareStrings();
        new TypeCasting().downcastHazard();
        new Conditionals().traditionalSwitch(3);
        new OutputModule().demonstrateFormatting();
        new LoopsModule().breakAndContinue();

        // --- CORE OBJECTS & LOGIC ---
        new VectorModule().demonstrateVector();
        new MethodsModule().factorial(5);
        new StringsModule().demonstrationPool();
        new ArraysModule().utilityMethods();
        // 11. Classes & Objects
        System.out.println("\n>>> Checking Classes Module...");
        ClassesModule.main(null); // Accessed statically

        // --- OOPS ---
        new Inheritance().demonstrate();
        new Polymorphism().demonstration();
        new Abstraction().demonstrate();

        // --- ADVANCED CORE ---
        new CollectionsModule().demonstrateList();
        new ExceptionModule().demonstrateBasics(10, 0);
        new WrapperModule().integerCacheBug();
        new GenericsModule().demonstrateGenericClass();

        // --- MODERN & CONCURRENT ---
        new Multithreading().demonstrate(); 
        new ModernJava().demonstrateStreams();
        new FileModule().demonstrateLegacyIO();

        // --- SPECIALIZED & PERFORMANCE ---
        new AdvancedBasics().demonstrateEnums();
        new AdvancedTopics().demonstrateReflection();
        new JDBCModule().demonstrateJDBCWorkflow();
        new JVMModule().demonstrateGCRequest();

        System.out.println("\n====================================================");
        System.out.println("✅ ALL 26+ JAVA MODULES TESTED & READY");
        System.out.println("====================================================");
    }
}
