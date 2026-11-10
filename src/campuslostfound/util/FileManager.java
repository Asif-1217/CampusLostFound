package campuslostfound.util;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileManager {

    public void saveToFile(String fileName, String data) {

        try {
            FileWriter writer = new FileWriter(fileName, true);

            writer.write(data + "\n");
            writer.close();

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void readFromFile(String fileName) {

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}