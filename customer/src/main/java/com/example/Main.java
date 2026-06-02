package com.example;

import com.example.dao.CustomerDao;
import com.example.model.Customer;

public class Main {

    public static void main(String[] args) {

        CustomerDao customerDao = new CustomerDao();

        Customer customer = new Customer(
                null,
                "Artem Chered",
                "artem@gmail.com",
                "28171326"
        );

        customerDao.add(customer);

        System.out.println(customerDao.findAll());

        System.out.println(customerDao.findById(1L));


        Customer updatedCustomer = new Customer(
                1L,
                "Updated Artem",
                "chered@gmail.com",
                "11112222"
        );

        customerDao.update(updatedCustomer);


        //customerDao.delete(1L);
    }
}