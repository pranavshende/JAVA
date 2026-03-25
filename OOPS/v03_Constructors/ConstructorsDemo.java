package OOPS.v03_Constructors;

/**
 * 📘 TOPIC: CONSTRUCTORS
 * 
 * 1. Default Constructor: Provided by the compiler if none is defined.
 * 2. Parameterized Constructor: Used to initialize objects with specific values.
 * 3. Copy Constructor: Used to create a new object from an existing one.
 * 4. Overloading: Having multiple constructors with different parameter lists.
 */

class Student {
    String name;
    int rollNo;

    // [1] BASIC: Default Constructor (No-argument)
    // Used to set default values if no inputs are provided.
    Student() {
        System.out.println("Default Constructor called. Initializing default values.");
        this.name = "Unknown Student";
        this.rollNo = 0;
    }

    // [2] INTERMEDIATE: Parameterized Constructor
    // Used to initialize custom values during object creation.
    Student(String name, int rollNo) {
        System.out.println("Parameterized Constructor called. Initializing custom values.");
        this.name = name;
        this.rollNo = rollNo;
    }

    // [3] ADVANCED: Copy Constructor
    // Used to create a deep copy of an existing object.
    Student(Student existingStudent) {
        System.out.println("Copy Constructor called. Creating copy of: " + existingStudent.name);
        this.name = existingStudent.name;
        this.rollNo = existingStudent.rollNo;
    }

    void displayInfo() {
        System.out.println("Student Name: " + name + ", Roll No: " + rollNo);
    }
}

/**
 * INTERVIEW FOCUS: Constructor Chaining using this()
 * 
 * Note: this() must be the first statement in a constructor.
 */
class Account {
    String accountNo;
    double balance;

    // Default Account
    Account() {
        this("000000", 0.0); // Chains to the parameterized constructor
        System.out.println("Default Account initialized via chaining.");
    }

    // Basic Account
    Account(String accountNo) {
        this(accountNo, 500.0); // Chains with a default opening balance
    }

    // Main parameterized constructor
    Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void showAccount() {
        System.out.println("Account: " + accountNo + ", Balance: $" + balance);
    }
}

public class ConstructorsDemo {
    public static void main(String[] args) {
        System.out.println("--- Student Examples ---");
        // Using Default Constructor
        Student s1 = new Student();
        s1.displayInfo();

        // Using Parameterized Constructor
        Student s2 = new Student("Alice", 101);
        s2.displayInfo();

        // Using Copy Constructor
        Student s3 = new Student(s2);
        s3.displayInfo();

        System.out.println("\n--- Account Examples (Chaining) ---");
        // Using Constructor Chaining
        Account acc1 = new Account();
        acc1.showAccount();

        Account acc2 = new Account("SB12345");
        acc2.showAccount();

        // [4] EDGE CASE: Incorrect usage
        // Account acc3 = new Account; // INCORRECT: Missing () calls the constructor incorrectly
        // Student s4 = new Student("Bob"); // INCORRECT: No constructor for single String parameter exists.
    }
}

/**
 * 💡 DRY RUN EXPLANATION:
 * 1. For s1: Default Constructor is called. Sets name = "Unknown Student".
 * 2. For s2: Parameterized Constructor is called. Sets name = "Alice".
 * 3. For s3: Copy constructor is called. s3's fields are copied from s2's fields.
 * 4. For acc1: Default constructor is called -> this(...) call -> main constructor -> prints "Default account initialized" -> main constructor returns.
 */
