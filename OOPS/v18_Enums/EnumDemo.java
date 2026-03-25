package OOPS.v18_Enums;

/**
 * 📘 TOPIC: ENUMS (Enumerations)
 * 
 * 1. Enum: A special "class" representing a group of constants.
 * 2. Constants: Are written in UPPERCASE.
 * 3. Fields/Constructors: Enums can have fields, constructors, and methods.
 * 4. Iteration: Use values() to iterate through constants.
 */

// [1] BASIC: Simple Enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// [2] INTERMEDIATE: Enum with variables and constructors
enum OrderStatus {
    PENDING("WAITING"), 
    SHIPPED("ON_ROAD"), 
    DELIVERED("ARRIVED"), 
    CANCELLED("REJECTED");

    private String code;

    // [3] ADVANCED: Constructor in Enum
    // NOTE: Enum constructors are PRIVATE by default.
    OrderStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println("--- Simple Enum ---");
        Day today = Day.WEDNESDAY;
        System.out.println("Today is: " + today);

        // [4] INTERVIEW FOCUS: Using enum in Switch case
        System.out.println("\n--- Enum in Switch ---");
        switch(today) {
            case MONDAY: System.out.println("Working day!"); break;
            case SATURDAY: 
            case SUNDAY: System.out.println("Weekend yay!"); break;
            default: System.out.println("Regular day."); break;
        }

        System.out.println("\n--- Advanced Enum with fields ---");
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println("Status: " + status + " | Code: " + status.getCode());
        }

        // [5] EDGE CASE: Calling values() and valueOf()
        OrderStatus s = OrderStatus.valueOf("DELIVERED");
        System.out.println("\nStatus from Name: " + s);
        
        // OrderStatus error = OrderStatus.valueOf("FAILED"); // ERROR: IllegalArgumentException!
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. Day enum created.
 * 2. OrderStatus created with specific "code" values.
 * 3. values() returns an array of all constants in order.
 * 4. valueOf() finds a constant by name.
 * 5. Enum instance 'DELIVERED' already has code 'ARRIVED' initialized.
 */
