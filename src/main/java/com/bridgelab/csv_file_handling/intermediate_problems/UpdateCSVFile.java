package com.bridgelab.csv_file_handling.intermediate_problems;

import java.io.*;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String inputFile = "employee.csv";  // Input CSV file
        String outputFile = "updated_employees.csv";  // Output CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine(); // Read the first line (header)
            if (line != null) {
                bw.write(line); // Write header to the new file
                bw.newLine();
            }

            // Process the rest of the file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split CSV row by comma

                // Ensure there are exactly 3 columns (Name, Department, Salary)
                if (data.length != 3) {
                    System.err.println("Skipping invalid row: " + line);
                    continue; // Skip rows that don't match the expected format
                }

                try {
                    String name = data[0].trim();
                    String department = data[1].trim();
                    double salary = Double.parseDouble(data[2].trim()); // Convert salary to double

                    // Increase salary by 10% if department is IT
                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10; // Increase by 10%
                    }

                    // Write updated data to new file
                    bw.write(name + "," + department + "," + String.format("%.2f", salary));
                    bw.newLine();
                } catch (NumberFormatException e) {
                    System.err.println("Skipping row with invalid salary: " + line);
                }
            }

            System.out.println("CSV file updated successfully!");

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
