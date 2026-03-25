package OOPS.v02_Classes_Objects;

/**
 * 📘 TOPIC: CLASSES AND OBJECTS
 * 
 * 1. Class: A blueprint/template for creating objects.
 * 2. Object: An instance of a class.
 * 
 * =========================================================================
 * BASIC EXAMPLE: Simple Class and Object initialization
 * =========================================================================
 */
class SimpleLaptop {
    String brand;
    int ram; // in GB

    // Method to display laptop info
    void showDetails() {
        System.out.println("Laptop brand: " + brand + ", RAM: " + ram + "GB");
    }
}

/**
 * INTERMEDIATE EXAMPLE: Real-World Object (Car)
 * 
 * Here we use multiple attributes and logic within methods.
 */
class Car {
    String model;
    String fuelType;
    int speed = 0;

    void accelerate(int increment) {
        speed += increment;
        System.out.println(model + " is accelerating. Current Speed: " + speed + " km/h");
    }

    void brake() {
        speed = 0;
        System.out.println(model + " has stopped.");
    }
}

/**
 * ADVANCED/INTERVIEW SCENARIO: Reference vs Value
 * 
 * Objects are stored in the Heap memory, and references are stored in the Stack memory.
 */
public class ClassesAndObjectsDemo {
    public static void main(String[] args) {
        // [1] BASIC: Creating objects
        SimpleLaptop laptop1 = new SimpleLaptop();
        laptop1.brand = "Dell";
        laptop1.ram = 8;
        laptop1.showDetails();

        // [2] INTERMEDIATE: Interacting with objects
        Car myCar = new Car();
        myCar.model = "Tesla Model S";
        myCar.fuelType = "Electric";
        myCar.accelerate(50);
        myCar.brake();

        // [3] EDGE CASE: NullPointerException
        // What happens if we use an uninitialized reference?
        @SuppressWarnings("unused")
        SimpleLaptop laptop2 = null;
        try {
            // laptop2.showDetails(); // This would throw NullPointerException
            System.out.println("\n--- Edge Case ---");
            System.out.println("laptop2 is null. Accessing it would throw NullPointerException.");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // [4] INTERVIEW FOCUS: Multiple references to the same object
        System.out.println("\n--- Interview Scenario: Object References ---");
        SimpleLaptop lapRef1 = new SimpleLaptop();
        lapRef1.brand = "MacBook";
        
        SimpleLaptop lapRef2 = lapRef1; // Both references point to the same object in Heap
        lapRef2.brand = "MacBook Pro"; // Modifying via lapRef2 changes what lapRef1 sees

        System.out.println("lapRef1 Brand: " + lapRef1.brand); // Will output 'MacBook Pro'
    }
}

/**
 * 💡 DRY RUN EXPLANATION:
 * 1. laptop1 is created in Heap. Its brand/ram are set to 'Dell'/8.
 * 2. myCar is created. model is set. accelerate() modifies the speed field.
 * 3. lapRef2 = lapRef1 does NOT create a new object. It copies the memory address from lapRef1 to lapRef2.
 * 4. Changing brand via lapRef2 affects lapRef1 because they share the same memory location.
 */
