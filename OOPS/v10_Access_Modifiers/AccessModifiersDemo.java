package OOPS.v10_Access_Modifiers;

/**
 * 📘 TOPIC: ACCESS MODIFIERS
 * 
 * 1. private: Accessible ONLY within the SAME class.
 * 2. (default): Accessible ONLY within the SAME package.
 * 3. protected: Accessible within SAME package + Subclasses (even in other packages).
 * 4. public: Accessible from ANY class in ANY package.
 */

class AccessBase {
    private int privateVar = 10;
    int defaultVar = 20; // Default (Package-private)
    protected int protectedVar = 30;
    public int publicVar = 40;

    void showVars() {
        System.out.println("--- Inside AccessBase ---");
        System.out.println("privateVar (accessible): " + privateVar);
        System.out.println("defaultVar (accessible): " + defaultVar);
        System.out.println("protectedVar (accessible): " + protectedVar);
        System.out.println("publicVar (accessible): " + publicVar);
    }
}

class AccessChild extends AccessBase {
    void showChildVars() {
        System.out.println("\n--- Inside AccessChild (Subclass) ---");
        // System.out.println("privateVar: " + privateVar); // COMPILE ERROR: private not accessible in subclass!
        System.out.println("defaultVar: " + defaultVar);
        System.out.println("protectedVar: " + protectedVar);
        System.out.println("publicVar: " + publicVar);
    }
}

public class AccessModifiersDemo {
    public static void main(String[] args) {
        AccessBase base = new AccessBase();
        base.showVars();

        System.out.println("\n--- Inside AccessModifiersDemo (Same Package) ---");
        // [1] BASIC: Access check
        // System.out.println("private: " + base.privateVar); // COMPILE ERROR!
        System.out.println("default: " + base.defaultVar);
        System.out.println("protected: " + base.protectedVar);
        System.out.println("public: " + base.publicVar);

        // [2] INTERVIEW FOCUS:
        // Q: Difference between protected and default?
        // A: Default is limited to the packet. Protected allows access from subclasses in OTHER packages too!
        
        // Q: Why private variables?
        // A: To follow Encapsulation and prevent accidental modification from outside.
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. AccessBase has fields with all 4 modifiers.
 * 2. AccessChild succeeds with default, protected, and public.
 * 3. Any class in the SAME package succeeds with everything EXCEPT private.
 * 4. Classes in DIFFERENT packages only succeed with public (and protected if subclassed).
 */
