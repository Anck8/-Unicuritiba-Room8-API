/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author 2018101665
 */
@Path("pi")
public class PI4WS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PI4WS
     */
    public PI4WS() {
    }

    /**
     * Retrieves representation of an instance of WS.PI4WS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
    return "teste";
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/{login}")
    public String getUsuario(@PathParam("login") String login){
        Usuario u = new Usuario();
        u.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        
        Gson g = new Gson();       
        return g.toJson(u);
    
    
    }

    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/lista")
    public String listaUsuario(){
        
        
        List<Usuario> lista;
    
        UsuarioDAO dao= new UsuarioDAO();        
        lista = dao.listar();        
       
        
        
        
        Gson g = new Gson();
        return g.toJson(lista);
    
    
    }
    
    @DELETE
    @Path("Usuario/excluir/{login}")
    public boolean excluir (@PathParam("login")String login)
    
    {        
        
        Usuario u = new Usuario();
        u.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);              
        return dao.excluir(u);
    
        
        
    }
    
    
    /**
     * PUT method for updating or creating an instance of PI4WS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
