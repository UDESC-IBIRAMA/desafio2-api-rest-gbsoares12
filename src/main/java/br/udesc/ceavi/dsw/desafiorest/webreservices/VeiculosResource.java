/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.desafiorest.webreservices;

import br.udesc.ceavi.dsw.desafiorest.dao.VeiculosDAO;
import br.udesc.ceavi.dsw.desafiorest.model.Veiculo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Gabriel Soares
 */
@Path("veiculos")
public class VeiculosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VeiculosResource
     */
    public VeiculosResource() {
    }

    /**
     * Retrieves representation of an instance of
     * br.udesc.ceavi.dsw.desafiorest.webresoucer.VeiculosResource
     *
     * @return an instance of br.udesc.ceavi.dsw.desafiorest.model.Veiculo
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getJson() {

        return VeiculosDAO.listarVeiculos();
    }

    /*
      TestObjectToJson obj = new TestObjectToJson();
      Gson gson = new Gson();

      //convert java object to JSON format
      String json = gson.toJson(obj);

      System.out.println(json);
     */
    @GET
    @Path("/montadoras")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMontadorasVeiculos() {
        Gson gson = new Gson();
        List listaObjResult = VeiculosDAO.listarMontadoras();

        List<Map<String, Object>> listJson = new ArrayList<>();
        for (Object veiculo : listaObjResult) {
            Map<String, Object> map = new HashMap<>();
            map.put("montadora", veiculo);
            listJson.add(map);
        }
        for (Map<String, Object> map : listJson) {
            String json = gson.toJson(map);
            System.out.println(json);
        }

        return gson.toJson(listJson);
    }
}
