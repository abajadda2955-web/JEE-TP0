package com.example.dao;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;


public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    // La classe de l'entité, déterminée au runtime via les génériques
    protected Class<T> entityClass;


    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        // Récupère le type paramétré de la classe fille
        // getGenericSuperclass() : obtient la classe parente avec les types génériques
        // getActualTypeArguments()[0] : prend le premier argument générique (T)
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        Transaction transaction = null;
        // try-with-resources : la session est automatiquement fermée
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity); // persist : attache l'entité à la session
            transaction.commit();    // Valide la transaction
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Annule la transaction en cas d'erreur
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity); // merge : met à jour l'entité si elle existe
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // get : récupère l'entité par sa clé primaire
            T entity = session.get(entityClass, id);
            // Optional : wrapper qui peut contenir une valeur null-safe
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL (Hibernate Query Language) : requête orientée objet
            return session.createQuery("from " + entityClass.getSimpleName(), entityClass)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // Retourne une liste vide en cas d'erreur
        }
    }

    @Override
    public void delete(ID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity); // remove : supprime l'entité
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}