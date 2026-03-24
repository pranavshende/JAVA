package FileIO;

import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * 📘 TOPIC 7: FILE INPUT & OUTPUT (I/O)
 * Communicating with the persistent storage.
 * Covers legacy IO and modern NIO.2 (FileSystem).
 */
public class FileModule {

    // =========================================================================
    // SECTION 1: LEGACY FILE I/O (InputStream, Reader)
    // =========================================================================

    // Q: Difference between InputStream and Reader?
    // A: InputStream: Reads raw bytes (8-bit). Used for binary data (images, etc).
    // A: Reader: Reads characters (16-bit). Used for localized text.
    public void demonstrateLegacyIO() {
        System.out.println("--- 1. Legacy IO (Writing) ---");
        try (FileWriter fw = new FileWriter("test.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Line 1: Hello Java I/O!");
            bw.newLine();
            bw.write("Line 2: Buffered writers are efficient.");
        } catch (IOException e) {
            System.err.println("Write failed: " + e.getMessage());
        }

        System.out.println("--- 1. Legacy IO (Reading) ---");
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.err.println("Read failed: " + e.getMessage());
        }
    }

    // =========================================================================
    // SECTION 2: MODERN NIO.2 (Files, Path)
    // =========================================================================

    // Q: Why prefer NIO.2 (introduced in Java 7)?
    // A: Better error handling, support for metadata, and simplified "one-line" operations.
    public void demonstrateModernNIO() {
        System.out.println("--- 2. Modern NIO.2 ---");
        Path path = Paths.get("modern.txt");

        try {
            // Write to file (one-liner)
            Files.writeString(path, "NIO.2 is powerful.\nIt handles character sets automatically.");

            // Read all lines at once
            List<String> allLines = Files.readAllLines(path);
            System.out.println("All lines count: " + allLines.size());

            // Check file properties
            System.out.println("Exists: " + Files.exists(path));
            System.out.println("Size: " + Files.size(path) + " bytes");

            // Delete file safely
            // Files.deleteIfExists(path);
        } catch (IOException e) {
            System.err.println("NIO error: " + e.getMessage());
        }
    }

    // =========================================================================
    // SECTION 3: KEY INTERVIEW QUESTIONS
    // =========================================================================

    /*
     * Q: What is Serialization?
     * A: The process of converting an object into a byte stream (to save or transmit).
     *    Class MUST implement the 'Serializable' interface.
     * 
     * Q: What is 'transient' keyword?
     * A: Used for fields that should NOT be serialized (e.g., passwords, sensitive data).
     * 
     * Q: Why close file resources?
     * A: To prevent "Resource Leaks" where the OS cannot reuse file handles, 
     *    potentially causing the application to crash under heavy load.
     *    (FIX: Always use try-with-resources).
     */

    // =========================================================================
    // SECTION 4: PERFORMANCE TIP - Buffering
    // =========================================================================

    /*
     * PERF TIP: Avoid naked FileReaders or FileWriters in loops.
     * Every call to a naked FileReader interacts with the OS file system!
     * 
     * FIX: Wrap them in 'BufferedReader' or 'BufferedWriter' to read/write 
     * in large chunks (8KB default), significantly reducing OS overhead.
     */
}
