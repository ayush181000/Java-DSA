package Vectors.src.com.ayush;

import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 456));
        employeeList.add(new Employee("Mary", "Smith", 789));
        employeeList.add(new Employee("Mike", "Wilson", 256));
        System.out.println(employeeList);
    }
}
