package com.example.servlet;

import com.example.model.Order;
import com.example.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/orders/*")
public class OrderServlet extends HttpServlet {

    private final OrderService orderService = new OrderService();
    private final ObjectMapper objectMapper = new ObjectMapper()
            .findAndRegisterModules();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Order order = objectMapper.readValue(req.getInputStream(), Order.class);

        orderService.create(order);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Long id = Long.parseLong(req.getPathInfo().substring(1));

        Order order = orderService.getById(id);

        if (order == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getOutputStream(), order);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Order order = objectMapper.readValue(req.getInputStream(), Order.class);

        orderService.update(order);

        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Long id = Long.parseLong(req.getPathInfo().substring(1));

        orderService.delete(id);

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}