package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/update-user")
public class UserUpdateServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère l'ID et les nouvelles données
        Long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Recherche l'utilisateur existant
        Optional<User> optionalUser = userDAO.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Met à jour les champs
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            // Ne met à jour le mot de passe que s'il est fourni
            if (password != null && !password.isEmpty()) {
                user.setPassword(password);
            }
            // Sauvegarde les modifications
            userDAO.update(user);
        }

        response.sendRedirect("users");
    }
}