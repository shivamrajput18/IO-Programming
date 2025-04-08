package com.bridgelab.csv_file_handling.intermediate_problems;

import java.io.*;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "employees.csv";  // Path to CSV file
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();  // Input name to search

        boolean found = false;  // Flag to check if employee is found

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV row into columns
                String[] columns = line.split(",");

                // Compare employee name (2nd column)
                if (columns[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + columns[2]);
                    System.out.println("Salary: " + columns[3]);
                    found = true;
                    break;  // Exit loop after finding the employee
                }
            }

            if (!found) {
                System.out.println("Employee not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
