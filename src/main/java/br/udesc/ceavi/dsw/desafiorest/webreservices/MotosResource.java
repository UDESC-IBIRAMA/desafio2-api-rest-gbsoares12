/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.webreservices;

import br.udesc.ceavi.dsw.desafiorest.dao.DAO;
import br.udesc.ceavi.dsw.desafiorest.dao.MotosDAO;
import br.udesc.ceavi.dsw.desafiorest.model.Moto;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Gabriel Soares
 */
@Path("motos")
public class MotosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MotosResource
     */
    public MotosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moto> getJson() {

        return MotosDAO.listarMoto();
    }
    
    @GET
    @Path("/cor/{cor}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Moto> buscaCor(final @PathParam("cor") String cor){
        return MotosDAO.buscaCor(cor);
    }
    
    @GET
    @Path("/motor/{motor}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Moto> buscaMotor(final @PathParam("motor") String motor){
        
        return MotosDAO.buscaMotor(motor);
    }
    
    @GET
    @Path("/modelo/{modelo}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Moto> buscaModelo(final @PathParam("modelo") String modelo){
        
        return MotosDAO.buscaModelo(modelo);
    }
    
    @GET
    @Path("/quilometragem/{quilometragem}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Moto> buscaQuilometragem(final @PathParam("quilometragem") String quilometragem){
        
        return MotosDAO.buscaQuilometragem(quilometragem);
    }
    
    @GET
    @Path("/montadora/{montadora}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Moto> buscaMontadora(final @PathParam("montadora") String montadora){
        
        return MotosDAO.buscaMontadora(montadora);
    }

    /**
     * PUT method for updating or creating an instance of MotoResource
     *
     * @param id
     * @param recebe um json de moto, compara os atribudos e no qual é diferente, ele atualiza, serve para excluir e adicionar atributos
     * @return objeto atualizado
     */
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public Moto putJson(final @PathParam("id") long id, Moto motoAtualizado) {
        Moto c = MotosDAO.atualizarMoto(id, motoAtualizado);

        return c;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public Moto postJson(Moto moto) {

        Moto m = (Moto) DAO.salvar(moto);
        return m;
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteJson(@PathParam("id") long id) {
        MotosDAO.deletarMotoId(id);
    }
}
