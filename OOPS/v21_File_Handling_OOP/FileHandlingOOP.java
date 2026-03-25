package OOPS.v21_File_Handling_OOP;

import java.io.*;

/**
 * 📘 TOPIC: FILE HANDLING USING OOP
 * 
 * 1. File Handling: Using Streams (Input/Output) or Readers/Writers to store data.
 * 2. OOP Principle: Abstraction (Abstract Class/Interface to handle different file modes).
 * 3. Encapsulation: Hiding file path and logic within 'FileHandler'.
 */

// [1] ABSTRACTION: Interface for specific file operations
interface IDataStore {
    void writeData(String data) throws IOException;
    String readData() throws IOException;
}

// [2] INTERMEDIATE: Base class for handling common file logic
abstract class FileHandler implements IDataStore {
    protected String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Common method to check if file exists
    public boolean exists() {
        File f = new File(filePath);
        return f.exists();
    }
}

// [3] ADVANCED: Specific Implementation (Text File Handler)
class TextFileHandler extends FileHandler {

    public TextFileHandler(String path) {
        super(path);
    }

    @Override
    public void writeData(String data) throws IOException {
        // Using BufferedWriter (Encapsulation of logic)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Data successfully written to: " + filePath);
        }
    }

    @Override
    public String readData() throws IOException {
        StringBuilder sb = new StringBuilder();
        // Using BufferedReader (Encapsulation of logic)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
}

public class FileHandlingOOP {
    public static void main(String[] args) {
        System.out.println("--- OOP File Handling Demonstration ---");

        String fileName = "sample_data.txt";
        TextFileHandler textHandler = new TextFileHandler(fileName);

        try {
            // [4] BASIC: Writing data
            textHandler.writeData("Hello, this is a line written using OOP File Handling!\nVersion 1.0");

            // [5] INTERMEDIATE: Reading data
            if (textHandler.exists()) {
                System.out.println("\nReading contents of: " + fileName);
                System.out.println("---------------------------------");
                System.out.println(textHandler.readData());
                System.out.println("---------------------------------");
            }

            // [6] EDGE CASE: File not found
            // TextFileHandler invalidHandler = new TextFileHandler("Z:/non_existent_drive/file.txt");
            // invalidHandler.writeData("Should fail.");
            
        } catch (IOException e) {
            System.err.println("CRITICAL ERROR: " + e.getMessage());
        }

        // [7] INTERVIEW FOCUS:
        // Why use 'try-with-resources'?
        // Because it automatically closes the file streams, even if an exception occurs! (Better Resource Management).
    }
}

/**
 * 💡 DRY RUN SUMMARY:
 * 1. fileName = "sample_data.txt".
 * 2. textHandler is created with filePath.
 * 3. writeData() opens a FileWriter -> BufferedWriter -> writes String -> auto-closes.
 * 4. readData() opens a FileReader -> BufferedReader -> reads line by line -> auto-closes.
 * 5. try-with-resources ensures NO memory leaks.
 */
