package com.example.dao;

import com.example.config.DatabaseConfig;
import com.example.mapper.CustomerRowMapper;
import com.example.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDao() {
        this.jdbcTemplate = DatabaseConfig.jdbcTemplate();
    }

    public void add(Customer customer) {

        String sql = """
                INSERT INTO customer(full_name, email, security_number)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSecurityNumber()
        );
    }

    public Customer findById(Long id) {

        String sql = "SELECT * FROM customer WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new CustomerRowMapper(),
                id
        );
    }

    public List<Customer> findAll() {

        String sql = "SELECT * FROM customer";

        return jdbcTemplate.query(
                sql,
                new CustomerRowMapper()
        );
    }

    public void update(Customer customer) {

        String sql = """
                UPDATE customer
                SET full_name = ?, email = ?, security_number = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                customer.getFullName(),
                customer.getEmail(),
                customer.getSecurityNumber(),
                customer.getId()
        );
    }

    public void delete(Long id) {

        String sql = "DELETE FROM customer WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}