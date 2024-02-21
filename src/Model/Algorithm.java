package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algorithm {

    public List<Person> getPerson(String path, double money) throws Exception {
        List<Person> people = new ArrayList<>();

        File file = new File(path);
        if (!file.exists()) {
            throw new Exception("Path doesn't exist");
        }

        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                String address = parts[1];
                double salary;
                try {
                    salary = Double.parseDouble(parts[2]);
                } catch (NumberFormatException e) {
                    salary = 0; // default value if salary format is incorrect
                }
                people.add(new Person(name, address, salary));
            }
        } catch (IOException e) {
            throw new Exception("Can't read file");
        }

        // Sort people based on salary
        Collections.sort(people, Comparator.comparingDouble(Person::getSalary));

        return people;
    }

    public boolean copyWord(String source, String destination) throws Exception {
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            throw new Exception("Source path doesn't exist");
        }

        File destFile = new File(destination);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        try ( BufferedReader reader = new BufferedReader(new FileReader(sourceFile));  
              BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    writer.write(word + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new Exception("Can't read/write file");
        }

        return true;
    }
}
