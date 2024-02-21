package Controller;

import Model.Algorithm;
import Model.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Handler {

    Algorithm algorithm;
    BufferedReader reader;

    public Handler() {
        algorithm = new Algorithm();
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (NumberFormatException e) {
        } catch (Exception e) {
        }
    }

    public void findInfo() throws IOException, Exception {
        System.out.println("Enter full path of the text file: ");
        String path = reader.readLine();

        System.out.println("Enter minimum salary to search: ");
        double minSalary = Double.parseDouble(reader.readLine());

        List<Person> people = algorithm.getPerson(path, minSalary);
        displayPeople(people);
    }

    public void displayPeople(List<Person> people) {
        System.out.println("People with salaries greater than or equal to the specified amount:");
        System.out.println("Name\t\tAddress\t\tSalary");
        for (Person person : people) {
            System.out.println(person.getName() + "\t\t" + person.getAddress() + "\t\t" + person.getSalary());
        }
        System.out.println("Person with the least salary: " + people.get(0).getName());
        System.out.println("Person with the most salary: " + people.get(people.size() - 1).getName());
    }

    public void copyToNewFile() throws IOException, Exception {
        System.out.println("Enter source: ");
        String src = reader.readLine();

        System.out.println("Enter new file name: ");
        String destination = reader.readLine();
        algorithm.copyWord(src, destination);
    }
}
