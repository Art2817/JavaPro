package com.example.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {

    public static DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/customer_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("2817");

        return dataSource;
    }

    public static JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}