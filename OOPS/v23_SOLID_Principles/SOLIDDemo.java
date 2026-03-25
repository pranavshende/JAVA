package OOPS.v23_SOLID_Principles;

/**
 * 📘 TOPIC: SOLID PRINCIPLES
 * 
 * 1. Single Responsibility Principle (SRP)
 * 2. Open/Closed Principle (OCP)
 * 3. Liskov Substitution Principle (LSP)
 * 4. Interface Segregation Principle (ISP)
 * 5. Dependency Inversion Principle (DIP)
 */

// =========================================================================
// [1] S - SINGLE RESPONSIBILITY PRINCIPLE (SRP)
// A class should have only ONE reason to change.
// =========================================================================

class UserProfile {
    // Correct: Only handles user data.
    @SuppressWarnings("unused") private String name;
    @SuppressWarnings("unused") private String email;

    UserProfile(String name, String email) { this.name = name; this.email = email; }

    // INCORRECT OR BAD PRACTICE:
    // void saveToDatabase() { ... } // SHOULD NOT BE HERE. Use a separate DAO/Repository.
    // void sendEmailNotification() { ... } // SHOULD NOT BE HERE. Use a separate MailService.
}

class UserRepository {
    void save(UserProfile user) {
        System.out.println("SRP: Saving user to DB...");
    }
}

// =========================================================================
// [2] O - OPEN/CLOSED PRINCIPLE (OCP)
// Software entities should be open for extension, but closed for modification.
// =========================================================================

interface PriceStrategy {
    double calculate(double price);
}

class RegularPrice implements PriceStrategy {
    @Override public double calculate(double price) { return price; }
}

class DiscountPrice implements PriceStrategy {
    @Override public double calculate(double price) { return price * 0.9; }
}

// If we want a new strategy (e.g., SeasonalPrice), we just IMPLEMENT the interface.
// We DO NOT modify the existing PriceCalculator class.
class PriceCalculator {
    double getFinalPrice(double price, PriceStrategy strategy) {
        return strategy.calculate(price);
    }
}

// =========================================================================
// [3] L - LISKOV SUBSTITUTION PRINCIPLE (LSP)
// Subclasses should be substitutable for their base classes without breaking anything.
// =========================================================================

interface Bird { void eat(); }
interface FlyingBird extends Bird { void fly(); }

class Sparrow implements FlyingBird {
    @Override public void eat() { System.out.println("Sparrow is eating."); }
    @Override public void fly() { System.out.println("Sparrow is flying."); }
}

class Ostrich implements Bird {
    @Override public void eat() { System.out.println("Ostrich is eating."); }
    // Ostrich cannot fly, so it won't implement FlyingBird.
    // This maintains LSP!
}

// =========================================================================
// [4] I - INTERFACE SEGREGATION PRINCIPLE (ISP)
// Clients should not be forced to depend on methods they don't use.
// =========================================================================

// Large interfaces should be split into smaller, more specific ones.
interface Workable { void work(); }
interface Sleepable { void sleep(); }

class HumanWorker implements Workable, Sleepable {
    @Override public void work() { System.out.println("Working..."); }
    @Override public void sleep() { System.out.println("Sleeping..."); }
}

class RobotWorker implements Workable {
    // Robot only implements Workable since it doesn't need Sleepable.
    @Override public void work() { System.out.println("Robot outputting work..."); }
}

// =========================================================================
// [5] D - DEPENDENCY INVERSION PRINCIPLE (DIP)
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// =========================================================================

interface MessageService { void send(String msg); }

class EmailService implements MessageService {
    @Override public void send(String msg) { System.out.println("Email: " + msg); }
}

class SMSService implements MessageService {
    @Override public void send(String msg) { System.out.println("SMS: " + msg); }
}

// High-level module: Notified system
class Notifier {
    private MessageService service; // Depends on ABSTRACTION

    // Dependency Injection via constructor
    Notifier(MessageService service) { this.service = service; }

    void notifyUser(String text) {
        service.send(text);
    }
}

public class SOLIDDemo {
    public static void main(String[] args) {
        System.out.println("--- SOLID Principles Demonstration ---");

        // [SRP]
        UserProfile p = new UserProfile("John", "john@email.com");
        new UserRepository().save(p);

        // [OCP]
        PriceCalculator calc = new PriceCalculator();
        System.out.println("Final Price (Discount): $" + calc.getFinalPrice(100.0, new DiscountPrice()));

        // [DIP]
        Notifier emailNotifier = new Notifier(new EmailService());
        emailNotifier.notifyUser("Hello via SOLID!");

        // [ISP / LSP] Birds and Workers behavior shows how to separate concerns and ensure correct substitution.
    }
}
/**
 * 💡 DRY RUN EXPLANATION (SOLID):
 * 1. Each class has one focus (SRP).
 * 2. Adding a new behavior requires simple extension, not modification (OCP).
 * 3. Subclasses like Ostrich don't throw "NotSupportedException" for things their parent supports (LSP).
 * 4. Robots don't have empty sleep() methods (ISP).
 * 5. Notifier doesn't care if it's Email or SMS; it just needs a MessageService (DIP).
 */
