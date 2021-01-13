package com.borlok.servletpractice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {
    private String message;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter messageWriter = resp.getWriter();

        messageWriter.println("<h1>" + message + "</h1>");

    }

    public void destroy() {
    }

    public void init() throws ServletException {
        message = "This is a new message";
    }
}
