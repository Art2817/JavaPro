package com.example.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;

class OrderServletTest {

    @Test
    void testDoGet() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getPathInfo()).thenReturn("/1");

        PrintWriter writer = mock(PrintWriter.class);

        when(response.getWriter()).thenReturn(writer);

        OrderServlet servlet = new OrderServlet();

        servlet.doGet(request, response);

        verify(request, times(1)).getPathInfo();
    }
}