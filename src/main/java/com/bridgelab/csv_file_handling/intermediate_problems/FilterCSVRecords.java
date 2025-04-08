package com.bridgelab.csv_file_handling.intermediate_problems;

import java.io.*;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "students.csv";  // Path to CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Students scoring more than 80 marks:");

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV row into columns
                String[] columns = line.split(",");

                // Parse marks (4th column)
                int marks = Integer.parseInt(columns[3]);

                // Print students scoring more than 80
                if (marks > 80) {
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


