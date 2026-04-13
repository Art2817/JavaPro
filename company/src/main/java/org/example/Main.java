package org.example;

import org.example.dao.EmployeeDAO;
import org.example.db.DatabaseConnector;
import org.example.model.Employee;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnector.connect()) {
            EmployeeDAO dao = new EmployeeDAO(conn);

            try (java.sql.Statement stmt = conn.createStatement()) {
                stmt.execute("TRUNCATE TABLE employees RESTART IDENTITY");
                System.out.println("Database cleaned. Identity restarted.\n");
            }

            dao.addEmployee(new Employee("Artem", 90, "Developer", 1000));
            dao.addEmployee(new Employee("Anna", 30, "Manager", 1500));
            dao.updateEmployee(1, "Senior Developer", 2000);

            System.out.println("Employees:");
            List<Employee> list = dao.getAllEmployees();
            for (Employee e : list) {
                System.out.println(e);
            }

            dao.deleteEmployee(2);

            System.out.println("\nAfter delete:");
            list = dao.getAllEmployees();
            for (Employee e : list) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}