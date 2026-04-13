package org.example.dao;

import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee e) throws SQLException {
        String sql = "INSERT INTO employees(name, age, position, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, e.getName());
        ps.setInt(2, e.getAge());
        ps.setString(3, e.getPosition());
        ps.setFloat(4, e.getSalary());
        ps.executeUpdate();
        ps.close();
    }

    public void updateEmployee(int id, String position, float salary) throws SQLException {
        String sql = "UPDATE employees SET position=?, salary=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, position);
        ps.setFloat(2, salary);
        ps.setInt(3, id);
        ps.executeUpdate();
        ps.close();
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Employee e = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("position"),
                    rs.getFloat("salary")
            );
            list.add(e);
        }

        rs.close();
        stmt.close();
        return list;
    }
}