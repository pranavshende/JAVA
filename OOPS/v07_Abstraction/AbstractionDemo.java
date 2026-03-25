package OOPS.v07_Abstraction;

/**
 * 📘 TOPIC: ABSTRACTION
 * 
 * 1. Abstraction: Showing only the functionality and hiding the background details.
 * 2. Abstract Class: A class declared as 'abstract' that CANNOT be instantiated.
 * 3. Abstract Method: A method declared without an implementation.
 */

// [1] BASIC: Abstract Class
abstract class Shape {
    String color;

    // Abstract classes can have constructors
    Shape(String color) { this.color = color; }

    // Abstract method: MUST be implemented by child classes.
    abstract double calculateArea();

    // Concrete method: Common functionality.
    void display() {
        System.out.println("Shape color: " + color);
    }
}

// [2] INTERMEDIATE: Subclass implementation
class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

/**
 * [3] ADVANCED: Practical usage in frameworks
 * 
 * When we want to force child classes to implement certain behavior while 
 * providing some basic default implementation.
 */
abstract class BaseService {
    abstract void processRequest();

    void logRequest() {
        System.out.println("Logging the request to the database...");
    }
}

class AuthService extends BaseService {
    @Override
    void processRequest() {
        logRequest();
        System.out.println("Authenticating user credentials...");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        System.out.println("--- Abstraction with Shapes ---");
        // [4] INCORRECT USAGE:
        // Shape s = new Shape("Red"); // COMPILE ERROR: Abstract class cannot be instantiated.

        // Correct usage with polymorphic reference:
        Shape s1 = new Circle("Blue", 5.0);
        Shape s2 = new Rectangle("Green", 10.0, 5.0);

        s1.display();
        System.out.println("Circle Area: " + s1.calculateArea());

        s2.display();
        System.out.println("Rectangle Area: " + s2.calculateArea());

        System.out.println("\n--- BaseService Demo ---");
        AuthService auth = new AuthService();
        auth.processRequest();

        // [5] INTERVIEW FOCUS:
        // Q: Can an abstract class have 0 abstract methods?
        // A: YES. It just means it cannot be instantiated.
        
        // Q: Can an abstract method be private or final?
        // A: NO. It must be accessible by child classes to be overridden.
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Abstraction):
 * 1. Shape s1 = new Circle(...) calls Circle's constructor -> super() calls Shape's constructor.
 * 2. s1.display() executes code from Shape (Concrete method).
 * 3. s1.calculateArea() executes code from Circle (Abstract method implementation).
 */
