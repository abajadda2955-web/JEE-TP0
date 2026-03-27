package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Test</title></head>");
        out.println("<body>");
        out.println("<h1 style='color:green'>Jetty fonctionne correctement !</h1>");
        out.println("<p>Votre application Jakarta EE est opérationnelle.</p>");
        out.println("<hr>");
        out.println("<a href='/inventory-management/'>Retour à l'accueil</a>");
        out.println("</body>");
        out.println("</html>");
    }
}