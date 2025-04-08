package com.bridgelab.csv_file_handling.basic_problems;

import java.io.*;

public class WriteCsv {
    public static void main(String[] args) {
        String filePath = "employees.csv";  // Define the CSV file path

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing the header row
            writer.write("ID,Name,Department,Salary\n");

            // Writing employee records
            writer.write("101,John Doe,Finance,60000\n");
            writer.write("102,Jane Smith,HR,55000\n");
            writer.write("103,Bob Johnson,IT,70000\n");
            writer.write("104,Alice Williams,Sales,65000\n");
            writer.write("105,Charlie Brown,Marketing,62000\n");

            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

