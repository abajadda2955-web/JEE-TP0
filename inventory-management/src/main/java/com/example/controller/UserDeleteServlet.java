package com.example.controller;

import com.example.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-user")
public class UserDeleteServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère l'ID de l'utilisateur à supprimer
        Long id = Long.parseLong(request.getParameter("id"));

        // Supprime l'utilisateur
        userDAO.delete(id);

        // Redirige vers la liste
        response.sendRedirect("users");
    }
}