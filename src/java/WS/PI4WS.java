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
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
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


    public PI4WS() {
    }
    
    //Select all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/lista")
    public String listar(){
    
        List<Usuario> lista;    
        UsuarioDAO dao= new UsuarioDAO();        
        
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    
    }
    
    
    //Select com where
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/{login}")
    public String buscar(@PathParam("login") int ID_USUARIO){
        Usuario u = new Usuario();
        u.setID_USUARIO(ID_USUARIO);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        
        Gson g = new Gson();       
        return g.toJson(u);
    
    
    }

    //Insert tabela Usuario
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("Usuario/inserir")
    public boolean inserir(String content){
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.inserir(u);
    }

   
    //delete com where
    @DELETE
    @Path("Usuario/excluir/{login}")
    public boolean excluir (@PathParam("login")int ID_USUARIO){        
        
        Usuario u = new Usuario();
        u.setID_USUARIO(ID_USUARIO);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);              
        return dao.excluir(u); 
        
    }
    

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/alterar")
    public void alterar (String content){
    //teste
        Gson g = new Gson();
    Usuario u = (Usuario) g.fromJson(content, Usuario.class);
    UsuarioDAO dao = new UsuarioDAO();
    dao.atualizar(u);
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
