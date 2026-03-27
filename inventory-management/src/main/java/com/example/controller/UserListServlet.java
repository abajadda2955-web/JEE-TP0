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
import java.util.List;

/**
 * Servlet qui affiche la liste des utilisateurs
 * @WebServlet : Déclare l'URL à laquelle la servlet répond
 */
@WebServlet("/users")
public class UserListServlet extends HttpServlet {

    private UserDAO userDAO;

    /**
     * init() : Méthode appelée à l'initialisation de la servlet
     * Crée une instance du DAO pour interagir avec la base
     */
    public void init() {
        userDAO = new UserDAO();
    }

    /**
     * doGet() : Traite les requêtes HTTP GET
     * Récupère la liste des utilisateurs et les envoie à la JSP
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère tous les utilisateurs de la base
        List<User> users = userDAO.findAll();

        // Ajoute la liste en attribut de requête (accessible dans la JSP)
        request.setAttribute("users", users);

        // Redirige vers la JSP d'affichage
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
}