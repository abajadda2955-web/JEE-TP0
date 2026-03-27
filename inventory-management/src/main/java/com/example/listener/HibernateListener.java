package com.example.listener;

import com.example.util.HibernateUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Écouteur de contexte servlet
 * Permet d'initialiser Hibernate au démarrage de l'application
 * et de fermer proprement à l'arrêt
 *
 * @WebListener : Déclare cette classe comme écouteur de servlet
 */
@WebListener
public class HibernateListener implements ServletContextListener {

    /**
     * Méthode appelée lors du démarrage de l'application
     * Initialise la SessionFactory Hibernate
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=== Démarrage de l'application ===");
        System.out.println("Initialisation de Hibernate...");
        HibernateUtil.getSessionFactory();
        System.out.println("Hibernate initialisé avec succès !");
    }

    /**
     * Méthode appelée lors de l'arrêt de l'application
     * Ferme proprement les ressources Hibernate
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=== Arrêt de l'application ===");
        System.out.println("Fermeture de Hibernate...");
        HibernateUtil.shutdown();
        System.out.println("Hibernate fermé avec succès !");
    }
}