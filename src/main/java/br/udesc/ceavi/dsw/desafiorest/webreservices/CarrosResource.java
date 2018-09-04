/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.webreservices;

import br.udesc.ceavi.dsw.desafiorest.dao.CarrosDAO;
import br.udesc.ceavi.dsw.desafiorest.dao.DAO;
import br.udesc.ceavi.dsw.desafiorest.model.Carro;
import br.udesc.ceavi.dsw.desafiorest.model.Veiculo;
import java.util.ArrayList;
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
@Path("carros")
public class CarrosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarrosResource
     */
    public CarrosResource() {
    }

    /**
     * Retrieves representation of an 
     * instance of
     * br.udesc.ceavi.dsw.desafiorest.model.CarrosResource
     *
     * @return an instance of br.udesc.ceavi.dsw.desafiorest.model.Carro
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carro> getJson() {

        return CarrosDAO.listarCarros();
    }
    
    @GET
    @Path("/cor/{cor}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Carro> buscaCor(final @PathParam("cor") String cor){
        return CarrosDAO.buscaCor(cor);
    }
    
    @GET
    @Path("/motor/{motor}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Carro> buscaMotor(final @PathParam("motor") String motor){
        
        return CarrosDAO.buscaMotor(motor);
    }
    
    @GET
    @Path("/modelo/{modelo}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Carro> buscaModelo(final @PathParam("modelo") String modelo){
        
        return CarrosDAO.buscaModelo(modelo);
    }
    
    @GET
    @Path("/quilometragem/{quilometragem}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Carro> buscaQuilometragem(final @PathParam("quilometragem") String quilometragem){
        
        return CarrosDAO.buscaQuilometragem(quilometragem);
    }
    
    @GET
    @Path("/montadora/{montadora}")
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public List<Carro> buscaMontadora(final @PathParam("montadora") String montadora){
        
        return CarrosDAO.buscaMontadora(montadora);
    }

    /**
     * PUT method for updating or creating an instance of CarrosResource
     *
     * @param id
     * @param recebe um json de carro, compara os atribudos e no qual é diferente, ele atualiza, serve para excluir e adicionar atributos
     * @return objeto atualizado
     */
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public Carro putJson(final @PathParam("id") long id, Carro carroAtualizado) {
        Carro c = CarrosDAO.atualizarCarro(id, carroAtualizado);

        return c;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)//O formato que irá receber
    @Produces(MediaType.APPLICATION_JSON)//O formato que irá produzir
    public Carro postJson(Carro carro) {

        Carro c = (Carro) DAO.salvar(carro);
        return c;
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteJson(@PathParam("id") long id) {
        CarrosDAO.deletarCarroId(id);
    }

}
