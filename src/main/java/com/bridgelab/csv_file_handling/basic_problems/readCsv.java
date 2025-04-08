package com.bridgelab.csv_file_handling.basic_problems;
import java.io.*;


public class readCsv {
    public static void main(String[] args) {
        String filePath = "students.csv";  // Path to CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line (if any)
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] columns = line.split(",");

                // Extract student details
                String id = columns[0];  // Student ID
                String name = columns[1];  // Student Name
                String age = columns[2];  // Student Age
                String marks = columns[3];  // Student Marks

                // Print the student details in a structured format
                System.out.println("Student ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

