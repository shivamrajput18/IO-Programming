package com.bridgelab.csv_file_handling.advanced_problem;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String inputFile = "contacts.csv"; // Input CSV file

        // Define Regex Patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; // Simple email validation
        String phoneRegex = "^[0-9]{10}$"; // Exactly 10 digits

        // Compile regex patterns
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine(); // Read the first line (header)
            if (line != null) {
                System.out.println("Valid records:");
                System.out.println(line); // Print header
            }

            // Process the rest of the file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split CSV row by comma

                // Ensure there are exactly 3 columns (Name, Email, Phone Number)
                if (data.length != 3) {
                    System.err.println("Skipping invalid row (Incorrect format): " + line);
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();

                // Validate email and phone number
                if (!emailPattern.matcher(email).matches()) {
                    System.err.println("Invalid email format: " + email + " (Row: " + line + ")");
                    continue;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.err.println("Invalid phone number: " + phone + " (Row: " + line + ")");
                    continue;
                }

                // If valid, print or store the valid record
                System.out.println(name + "," + email + "," + phone);
            }

            System.out.println("CSV validation completed!");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
