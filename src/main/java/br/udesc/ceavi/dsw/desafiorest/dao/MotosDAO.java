/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.dao;

import br.udesc.ceavi.dsw.desafiorest.model.Moto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gabriel Soares
 */
public class MotosDAO {
    
    public static List<Moto> listarMoto() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        return em.createQuery("SELECT m FROM Moto m ORDER BY m.id").getResultList();
    }

    public static Moto buscarMotoId(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.id=:id");
        consulta.setParameter("id", id);
        Moto m = (Moto) consulta.getSingleResult();

        return m;
    }

    public static void deletarMotoId(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.id=:id");
        consulta.setParameter("id", id);
        Object m = consulta.getSingleResult();

        em.getTransaction().begin();
        try {

            em.remove(m);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }
    
    public static List<Moto> buscaCor(String corBuscar) {//Pesquisa cor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.cor=:cor");
        consulta.setParameter("cor", corBuscar);

        return consulta.getResultList();
    }
    
    

    public static List<Moto> buscaMontadora(String montadoraBuscar) {//Pesquisa montadora
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.montadora=:montadora");
        consulta.setParameter("montadora", montadoraBuscar);

        return consulta.getResultList();
    }
    
    

    public static List<Moto> buscaModelo(String modeloBuscar) {//Pesquisa modelo
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.modelo=:modelo");
        consulta.setParameter("modelo", modeloBuscar);

        return consulta.getResultList();
    }
    
    

    public static List<Moto> buscaMotor(String motorBuscar) {//Pesquisa motor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.motor=:motor");
        consulta.setParameter("motor", motorBuscar);

        return consulta.getResultList();
    }
    

    public static List<Moto> buscaQuilometragem(String quilometragemBuscar) {//Pesquisa quilometragem
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.quilometragem=:quilometragem");
        consulta.setParameter("quilometragem", quilometragemBuscar);

        return consulta.getResultList();
    }
    
    

    public static Moto atualizarMoto(long id_moto, Moto motoAtualizado) {
        Moto m = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT m FROM Moto m WHERE m.id=:id");
        consulta.setParameter("id", id_moto);
        m = (Moto) consulta.getSingleResult();
        m.setMontadora(motoAtualizado.getMontadora());
        m.setModelo(motoAtualizado.getModelo());
        m.setCor(motoAtualizado.getCor());
        m.setQuilometragem(motoAtualizado.getQuilometragem());
        m.setMotor(motoAtualizado.getMotor());
        em.getTransaction().begin();

        try {

            em.merge(m);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {

            em.close();

        }

        return m;
    }
}
