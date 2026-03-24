package Database;

import java.sql.*;

/**
 * 📘 TOPIC 12: JDBC (Java Database Connectivity)
 * How Java applications talk to actual SQL databases.
 * Covers basic steps and PreparedStatement for security.
 */
public class JDBCModule {

    // =========================================================================
    // SECTION 1: THE 7 STEPS OF JDBC
    // =========================================================================

    /*
     * 1. Import Packages: import java.sql.*
     * 2. Register Driver: Class.forName("com.mysql.cj.jdbc.Driver");
     * 3. Establish Connection: DriverManager.getConnection(url, user, pass);
     * 4. Create Statement: con.createStatement();
     * 5. Execute Query: rs = st.executeQuery(sql);
     * 6. Process Result: while(rs.next()) { // get data }
     * 7. Close Connection: con.close(); (Use try-with-resources!)
     */

    public void demonstrateJDBCWorkflow() {
        System.out.println("--- 1. JDBC Workflow (Mocked) ---");
        
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "password";

        // Try-with-resources (Automatic closing)
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connection established successfully.");
            
            // Q: Statement vs PreparedStatement?
            // A: Statement: Unprepared, slow, VULNERABLE to SQL Injection.
            // A: PreparedStatement: Compiled once, fast, SECURE. (Preferred).
            
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, 101); // Set the parameter safely
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Emp ID: " + rs.getInt("id") + " | Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // =========================================================================
    // SECTION 2: SQL INJECTION (CRITICAL SECURITY)
    // =========================================================================

    // Q: How to prevent SQL injection?
    // A: 1. NEVER use String concatenation for queries (e.g., query + username).
    // A: 2. ALWAYS use PreparedStatement with placeholders (?).
    // A: 3. Perform server-side validation.
    
    // BAD EXAMPLE (VULNERABLE):
    // String sql = "SELECT * FROM users WHERE pass = " + inputData + "";
    
    // GOOD EXAMPLE (SECURE):
    // String sql = "SELECT * FROM users WHERE pass = ?";
    // pst.setString(1, inputData);

    // =========================================================================
    // SECTION 3: TRANSACTION MANAGEMENT
    // =========================================================================

    // Q: What is a Transaction?
    // A: A single unit of work (e.g., Bank Transfer: Withdraw from A and Deposit to B).
    // A: Must be ACID (Atomicity, Consistency, Isolation, Durability).
    public void manageTransaction(Connection con) throws SQLException {
        try {
            con.setAutoCommit(false); // Start transaction
            
            // Perform multiple updates...
            // stmt.executeUpdate(...);
            
            con.commit(); // Success: Save all changes
        } catch (Exception e) {
            con.rollback(); // Failure: Undo ALL changes in this block
        }
    }

    // =========================================================================
    // SECTION 4: BATCH PROCESSING
    // =========================================================================

    /*
     * Q: How to insert 10,000 records efficiently?
     * A: Use 'addBatch()' and 'executeBatch()'. 
     *    Instead of sending 10,000 network calls to DB, send them all as one!
     */
}
