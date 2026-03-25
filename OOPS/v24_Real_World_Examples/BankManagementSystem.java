package OOPS.v24_Real_World_Examples;


/**
 * 🎯 REAL-WORLD MINI PROJECT: BANK MANAGEMENT SYSTEM
 * 
 * This example combines multiple OOPs concepts:
 * 1. Abstraction (Abstract Class/Interfaces)
 * 2. Encapsulation (Private fields, Getters/Setters)
 * 3. Inheritence (Savings/Current Accounts)
 * 4. Polymorphism (Method Overriding)
 * 5. Exception Handling (Insufficient Funds)
 */

// [1] ABSTRACTION: Interface for common banking operations
interface IBankOperations {
    void deposit(double amount);
    void withdraw(double amount) throws BankException;
    void transfer(IBankOperations target, double amount) throws BankException;
    void showBalance();
}

// [2] EXCEPTION HANDLING: Custom Exception
class BankException extends Exception {
    public BankException(String msg) { super(msg); }
}

// [3] ABSTRACTION + ENCAPSULATION: Base Account class
abstract class Account implements IBankOperations {
    private final String accountNumber;
    private final String ownerName;
    protected double balance; // Protected so subclasses can access it

    public Account(String accNo, String owner, double initialBalance) {
        this.accountNumber = accNo;
        this.ownerName = owner;
        this.balance = initialBalance;
    }

    // Common getter methods
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to " + accountNumber);
        }
    }

    @Override
    public void showBalance() {
        System.out.println("Account: " + accountNumber + " | Owner: " + ownerName + " | Balance: $" + balance);
    }

    @Override
    public void transfer(IBankOperations target, double amount) throws BankException {
        System.out.println("Initiating transfer of $" + amount + " from " + accountNumber);
        this.withdraw(amount); // Deduct from self
        target.deposit(amount); // Add to target
        System.out.println("Transfer successful!");
    }
}

// [4] INHERITANCE: Specific Account Types
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.04; // 4% constant

    public SavingsAccount(String accNo, String owner, double initialBalance) {
        super(accNo, owner, initialBalance);
    }

    // [5] POLYMORPHISM: Specific implementation of withdrawal
    @Override
    public void withdraw(double amount) throws BankException {
        // Enforce minimum balance rule
        if (balance - amount < 500.0) {
            throw new BankException("Savings Account Alert: Minimum $500 balance required.");
        }
        balance -= amount;
        System.out.println("Withdawn: $" + amount + " | New Balance: $" + balance);
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: $" + interest + " | Current Balance: $" + balance);
    }
}

class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accNo, String owner, double initialBalance) {
        super(accNo, owner, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws BankException {
        if (balance + OVERDRAFT_LIMIT < amount) {
            throw new BankException("Current Account Error: Overdraft limit exceeded!");
        }
        balance -= amount;
        System.out.println("Withdrawn (with Overdraft): $" + amount + " | Current Balance: $" + balance);
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== 🏦 WELCOME TO MINI-BANK SYSTEM ===");

        try {
            // [6] POLYMORPHISM: Using interface references
            Account savAcc = new SavingsAccount("SAV-101", "John Doe", 2000.0);
            Account curAcc = new CurrentAccount("CUR-202", "Jane Smith", 1000.0);

            savAcc.showBalance();
            curAcc.showBalance();

            System.out.println("\n--- Operations ---");
            savAcc.deposit(500);
            curAcc.withdraw(1500); // Uses overdraft

            System.out.println("\n--- Transfer Example ---");
            savAcc.transfer(curAcc, 300);

            System.out.println("\n--- Interest Calculation ---");
            // Downcasting to use specific method
            if (savAcc instanceof SavingsAccount) {
                ((SavingsAccount) savAcc).addInterest();
            }

            System.out.println("\n--- Edge Case: Failed Withdrawal ---");
            savAcc.withdraw(3000); // This failed due to Min Balance requirement.

        } catch (BankException e) {
            System.err.println("BANK SYSTEM ERROR: " + e.getMessage());
        }

        System.out.println("\n=== 👋 End of Bank Demonstration ===");
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. savAcc and curAcc created with initial balances.
 * 2. savAcc.deposit() calls parent method Account.deposit().
 * 3. curAcc.withdraw(1500) calls CurrentAccount.withdraw() -> goes into negative balance (-500) within 5000 limit.
 * 4. transfer(curAcc, 300) calls savAcc.withdraw() and curAcc.deposit().
 * 5. savAcc.withdraw(3000) results in (2200 - 3000 = -800) which < 500 -> Throws BankException.
 * 6. Main catch block catches the exception and prints the error message cleanly.
 */
