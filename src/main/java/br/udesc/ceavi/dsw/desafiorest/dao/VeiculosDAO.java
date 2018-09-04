/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.dao;

import br.udesc.ceavi.dsw.desafiorest.model.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel Soares
 */
public class VeiculosDAO {
    
    public static List<Veiculo> listarVeiculos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();

        return em.createQuery("SELECT v FROM Veiculo v ORDER BY v.id").getResultList();
    }

    public static List   listarMontadoras() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioRest");
        EntityManager em = emf.createEntityManager();
//        Object[] v = null;
//        try {
//
//            List teste = em.createQuery("SELECT OBJECT(v.montadora) FROM Veiculo v ORDER BY v.montadora ASC").getResultList();
//            v = teste.toArray();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            v = null;
//        }
//        
//        
        return em.createQuery("SELECT v.montadora FROM Veiculo v ORDER BY v.montadora ASC").getResultList();
    }

}
