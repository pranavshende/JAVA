package OOPS.v04_Encapsulation;

/**
 * 📘 TOPIC: ENCAPSULATION
 * 
 * 1. Data Hiding: Making fields private to prevent direct access.
 * 2. Getters & Setters: Providing controlled access to data.
 * 3. Immutability: Making objects unchangeable once created.
 * 4. Control: Ability to modify data internally without affecting external access.
 */

// INTERMEDIATE: Bank Account Example with Data Validation
class BankAccount {
    // [1] BASIC: private variables (Data Hiding)
    private double balance;
    private final String accountNumber; // final for read-only behavior

    // [2] Parameterized Constructor to set initial values
    public BankAccount(String accountNo, double initialBalance) {
        this.accountNumber = accountNo;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting it to 0.");
            this.balance = 0;
        }
    }

    // [3] Getter Methods: Read access
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // [4] Setter Methods: Controlled modification (Data Validation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New Balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}

// ADVANCED: Immutable Class Example
// All fields are final and private. No setters provided.
final class ImmutableEmployee {
    private final int id;
    private final String name;

    public ImmutableEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    // Q: How to "change" data in an immutable object?
    // A: Return a NEW object with the modified data!
    public ImmutableEmployee withNewName(String newName) {
        return new ImmutableEmployee(this.id, newName);
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        System.out.println("--- BankAccount Encapsulation Example ---");
        BankAccount acc = new BankAccount("SAVING-12345", 1000.0);
        
        // [5] INCORRECT USAGE (Compiled Error):
        // acc.balance = 500000; // Cannot access balance directly due to 'private' modifier.
        
        // Correct Usage:
        acc.deposit(500.0);
        acc.withdraw(200.0);
        System.out.println("Final Account Balance: $" + acc.getBalance());

        System.out.println("\n--- Immutable Employee Example ---");
        ImmutableEmployee emp1 = new ImmutableEmployee(1, "John Doe");
        System.out.println("Original Employee: " + emp1.getName());

        // Modifying results in a new object
        ImmutableEmployee emp2 = emp1.withNewName("Jane Smith");
        System.out.println("Updated Employee (New Object): " + emp2.getName());
        System.out.println("Emp1 (Still Unchanged): " + emp1.getName());

        // [6] EDGE CASE / INTERVIEW FOCUS:
        // What if an immutable class has a mutable object like a List or Date?
        // In that case, we should return a "Defensive Copy" of that object.
    }
}

/**
 * 💡 DRY RUN EXPLANATION:
 * 1. acc object is created. Internal 'balance' is set via constructor logic.
 * 2. Withdrawal checks if 'amount <= balance'. If false, the balance remains unchanged.
 * 3. ImmutableEmployee fields cannot be reassigned after construction.
 * 4. withNewName() creates a completely new instance, demonstrating the concept of functional immutability.
 */
