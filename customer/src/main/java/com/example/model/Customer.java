package com.example.model;

public class Customer {

    private Long id;
    private String fullName;
    private String email;
    private String securityNumber;

    public Customer() {
    }

    public Customer(Long id, String fullName, String email, String SecurityNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.securityNumber = SecurityNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", securityNumber='" + securityNumber + '\'' +
                '}';
    }
}