package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create-user")
public class UserCreateServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    /**
     * doPost() : Traite les données du formulaire envoyées en POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère les paramètres du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Crée un nouvel objet User avec les données reçues
        User newUser = new User(firstName, lastName, email, password);

        // Sauvegarde en base
        userDAO.save(newUser);

        // Redirige vers la liste des utilisateurs
        response.sendRedirect("users");
    }
}