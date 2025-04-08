package com.bridgelab.csv_file_handling.basic_problems;

import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "students.csv";  // Path to CSV file
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                rowCount++;  // Increment for each record
            }

            System.out.println("Total Records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
