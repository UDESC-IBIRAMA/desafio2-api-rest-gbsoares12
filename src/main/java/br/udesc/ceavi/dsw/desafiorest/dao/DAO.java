/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel Soares
 */
public class DAO {
    
    public static Object ler(Class classe, long id) {
        Object object = null;
        EntityManagerFactory emf
                = javax.persistence.Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            object = em.find(classe, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return object;
    }

    public static void update(Object object) {
        EntityManagerFactory emf
                = javax.persistence.Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static Object salvar(Object objeto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();
        Object obj = null;
        
        em.getTransaction().begin();
        try {

            em.persist(objeto);
            em.getTransaction().commit();
            obj = objeto;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {

            em.close();

        }
        
        return obj;
    }

    public static void excluir(Object objeto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {

            em.remove(objeto);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }
}
