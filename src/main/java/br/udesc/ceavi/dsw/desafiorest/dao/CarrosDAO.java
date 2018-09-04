/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.dao;

import br.udesc.ceavi.dsw.desafiorest.model.Carro;
import br.udesc.ceavi.dsw.desafiorest.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gabriel Soares
 */
public class CarrosDAO extends DAO {

    public static List<Carro> listarCarros() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        return em.createQuery("SELECT c FROM Carro c ORDER BY c.id").getResultList();
    }

    public static Carro buscarCarroId(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.id=:id");
        consulta.setParameter("id", id);
        Carro c = (Carro) consulta.getSingleResult();

        return c;
    }

    public static void deletarCarroId(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.id=:id");
        consulta.setParameter("id", id);
        Object c = consulta.getSingleResult();

        em.getTransaction().begin();
        try {

            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }
    
    public static List<Carro> buscaCor(String corBuscar) {//Pesquisa cor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.cor=:cor");
        consulta.setParameter("cor", corBuscar);

        return consulta.getResultList();
    }
    
    

    public static List<Carro> buscaMontadora(String montadoraBuscar) {//Pesquisa montadora
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.montadora=:montadora");
        consulta.setParameter("montadora", montadoraBuscar);

        return consulta.getResultList();
    }
    
    

    public static List<Carro> buscaModelo(String modeloBuscar) {//Pesquisa modelo
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.modelo=:modelo");
        consulta.setParameter("modelo", modeloBuscar);

        return consulta.getResultList();
    }
    
    

    public static List<Carro> buscaMotor(String motorBuscar) {//Pesquisa motor
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.motor=:motor");
        consulta.setParameter("motor", motorBuscar);

        return consulta.getResultList();
    }
    

    public static List<Carro> buscaQuilometragem(String quilometragemBuscar) {//Pesquisa quilometragem
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.quilometragem=:quilometragem");
        consulta.setParameter("quilometragem", quilometragemBuscar);

        return consulta.getResultList();
    }
    
    

    public static Carro atualizarCarro(long id_carro, Carro carroAtualizado) {
        Carro c = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        Query consulta = em.createQuery("SELECT c FROM Carro c WHERE c.id=:id");
        consulta.setParameter("id", id_carro);
        c = (Carro) consulta.getSingleResult();
        c.setMontadora(carroAtualizado.getMontadora());
        c.setModelo(carroAtualizado.getModelo());
        c.setCor(carroAtualizado.getCor());
        c.setQuilometragem(carroAtualizado.getQuilometragem());
        c.setMotor(carroAtualizado.getMotor());
        em.getTransaction().begin();

        try {

            em.merge(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {

            em.close();

        }

        return c;
    }

}
