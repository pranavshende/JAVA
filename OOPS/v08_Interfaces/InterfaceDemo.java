package OOPS.v08_Interfaces;

/**
 * 📘 TOPIC: INTERFACES
 * 
 * 1. Interfaces: A blueprint for a class. Defines WHAT a class CAN DO.
 * 2. Multiple Inheritance: Supported in Java through interfaces.
 * 3. Default Methods (Java 8+): Concrete implementation inside interface.
 * 4. Static Methods (Java 8+): Utility methods inside interface.
 * 5. Functional Interfaces (Java 8+): Interfaces with only ONE abstract method.
 */

// [1] BASIC: Multiple Interfaces
interface Wireless { void connectWiFi(); }
interface Bluetooth { void connectBT(); }

// Class implementing multiple interfaces
class SmartPhone implements Wireless, Bluetooth {
    @Override
    public void connectWiFi() { System.out.println("Connecting to WiFi using 5G..."); }

    @Override
    public void connectBT() { System.out.println("Connecting to Bluetooth v5.2..."); }
}

/**
 * [2] INTERMEDIATE: Interface with Default and Static methods
 * 
 * Q: Why default methods?
 * A: To add new functionality to existing interfaces WITHOUT breaking current implementations.
 */
interface MediaElement {
    void play(); // public abstract by default

    // Concrete implementation in interface!
    default void stop() {
        System.out.println("Playback stopped (Default Implementation)");
    }

    // Utility method in interface!
    static void showCopyright() {
        System.out.println("Copyright (c) 2026, All Rights Reserved.");
    }
}

class VideoPlayer implements MediaElement {
    @Override
    public void play() {
        System.out.println("Playing video MP4...");
    }
}

/**
 * [3] ADVANCED: Functional Interface and Lambdas
 * 
 * Functional interfaces are used for Lambda expressions.
 */
@FunctionalInterface
interface Notifier {
    void sendMessage(String text);
}

public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("--- Multiple Inheritance Example ---");
        SmartPhone phone = new SmartPhone();
        phone.connectWiFi();
        phone.connectBT();

        System.out.println("\n--- Default/Static Methods Example ---");
        VideoPlayer vp = new VideoPlayer();
        vp.play();
        vp.stop(); // Calling default method
        MediaElement.showCopyright(); // Calling static method via Interface name

        System.out.println("\n--- Functional Interface & Lambda ---");
        // Using an Anonymous Class (Old way)
        Notifier n1 = new Notifier() {
            @Override
            public void sendMessage(String text) {
                System.out.println("Old notify: " + text);
            }
        };

        // Using Lambda Expression (Modern way)
        Notifier n2 = (msg) -> System.out.println("Modern notify: " + msg);
        
        n1.sendMessage("Hello World!");
        n2.sendMessage("Hello Lambda!");

        // [4] INTERVIEW FOCUS:
        // Q: Can an interface have a constructor?
        // A: NO. Interfaces cannot be instantiated.
        
        // Q: Difference between Interface and Abstract Class?
        // A: Interfaces define common BEHAVIOR ("Can-Do"). Abstract classes define common STRUCTURE ("Is-A").
    }
}

/**
 * 💡 DRY RUN EXPLANATION (Interfaces):
 * 1. SmartPhone inherits methods from both Wireless and Bluetooth.
 * 2. MediaElement.stop() is available to all implementing classes unless they override it.
 * 3. Functional Interface usage: n2 Lambda is essentially a shorthand for the interface implementation.
 */
