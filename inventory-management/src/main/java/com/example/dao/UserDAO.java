package com.example.dao;

import com.example.model.User;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;


public class UserDAO extends GenericDAOImpl<User, Long> {


    public Optional<User> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL : requête paramétrée
            Query<User> query = session.createQuery(
                    "from User where email = :email", User.class);
            query.setParameter("email", email);
            // uniqueResult : retourne un seul résultat ou null
            return Optional.ofNullable(query.uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}