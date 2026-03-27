package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/user-form")
public class UserFormServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère le paramètre "action" de l'URL
        String action = request.getParameter("action");

        // Si action = "edit", on charge l'utilisateur à modifier
        if (action != null && action.equals("edit")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Optional<User> user = userDAO.findById(id);
            // Si l'utilisateur existe, on le met en attribut de requête
            user.ifPresent(u -> request.setAttribute("user", u));
        }

        // Affiche le formulaire
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
}