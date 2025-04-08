package com.bridgelab.csv_file_handling.intermediate_problems;

import java.io.*;
import java.util.*;

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | " + String.format("%.2f", salary);
    }
}

public class SortCSVBySalary {
    public static void main(String[] args) {
        String inputFile = "employee.csv"; // Input CSV file
        List<Employee> employees = new ArrayList<>();

        // Read CSV and store data in a list
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine(); // Read header and ignore
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 3) {
                    System.err.println("Skipping invalid row: " + line);
                    continue;
                }

                try {
                    String name = data[0].trim();
                    String department = data[1].trim();
                    double salary = Double.parseDouble(data[2].trim());
                    employees.add(new Employee(name, department, salary));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping row with invalid salary: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Sort employees by salary in descending order
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        // Print the top 5 highest-paid employees
        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i));
        }
    }
}
