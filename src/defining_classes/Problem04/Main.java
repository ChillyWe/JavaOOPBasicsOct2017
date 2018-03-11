package defining_classes.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Chilly on 24.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] employeeData = reader.readLine().split("\\s+");
            int length = employeeData.length;
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            Employee currEmployee = null;

            switch (length) {
                case 4:
                    currEmployee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (employeeData[4].matches("\\d+")) {
                        int age = Integer.parseInt(employeeData[4]);
                        currEmployee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = employeeData[4];
                        currEmployee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = employeeData[4];
                    int age = Integer.parseInt(employeeData[5]);
                    currEmployee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            employeesByDepartment.putIfAbsent(department, new ArrayList<>());
            employeesByDepartment.get(department).add(currEmployee);
        }
        employeesByDepartment.entrySet().stream()
                .sorted((d1, d2) -> Double.compare(
                        d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1).forEach(d -> {
                    StringBuilder sb = new StringBuilder(String.format("Highest Average Salary: %s", d.getKey())).append(System.lineSeparator());
                    d.getValue().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(e -> sb.append(e).append(System.lineSeparator()));
            System.out.println(sb);
        });
    }
}