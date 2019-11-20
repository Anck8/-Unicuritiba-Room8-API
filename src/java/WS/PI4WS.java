/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import dao.Tp_cadastroDAO;
import dao.UsuarioDAO;
import java.lang.reflect.Type;
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
import modelo.Banco;
import modelo.Tp_cadastro;
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


    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }



    
    //Select all
    //Select que retorna informações de todos os Usuarios cadastrados
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/todos")
    public String listar(){
    
        List<Banco> lista; 
        UsuarioDAO dao= new UsuarioDAO();
        Banco u = new Banco(POST, POST, POST, POST, POST, POST);
        lista = dao.listar();

        Gson g = new Gson();
        
        return g.toJson(lista);
        
    }
    
    
    
    
    //Select que retorna informações de um Usuario
    //passando cpf como where
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/where/{cpf}")
    public String buscar(@PathParam("cpf") String cpf){
        Banco u = new Banco(POST, cpf, cpf, cpf, cpf, cpf);
        u.setCPF(cpf);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        
        Gson g = new Gson();       
        return g.toJson(u);    
    }
    
    
    
    
    //Select que retornta false ou true,
    //passando e-mail e senha no where.   
    //Usado para validar o login 
    @GET
    @Path("Usuario/get/logar/{email}/{senha}")
    public boolean logar(@PathParam("email") String email,@PathParam("senha") String senha){
        Usuario u = new Usuario(email, senha);
        u.setEMAIL(email);
        u.setSENHA(senha);        
        UsuarioDAO dao = new UsuarioDAO();
        dao.logar(u);
        return dao.logar(u);   
    
    }
    
    
 
    
    
    
    
    
    
    
    
    
    
    

    //Insert tabela Usuario
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Path("Usuario/inserir")
//    public boolean inserir(String content){
//        Gson g = new Gson();
//        Banco u = (Banco) g.fromJson(content, Banco.class);
//        
//        UsuarioDAO dao = new UsuarioDAO();
//        return dao.inserir(u);
//    }

   
//    //delete com where
//    @DELETE
//    @Path("Usuario/excluir/{login}")
//    public boolean excluir (@PathParam("login")int ID_USUARIO){        
//        
//        Usuario u = new Usuario(ID_USUARIO, POST, POST, POST, POST, POST);
//        u.setID_USUARIO(ID_USUARIO);
//        
//        UsuarioDAO dao = new UsuarioDAO();
//        u = dao.buscar(u);              
//        return dao.excluir(u); 
//        
//    }
    

//    @PUT
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Path("Usuario/alterar")
//    public boolean alterar(String content){
//        Gson g = new Gson();
//        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
//        
//        UsuarioDAO dao = new UsuarioDAO();
//        return dao.atualizar(u);
//    }
//    
    
    
    
    
   


    
    //Select que retorna todos os "tipos" de cadastros disponiveis
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Cadastro/get/listar_tp")
    public String listar_tp(){
    
        List<Tp_cadastro> lista;    
        Tp_cadastroDAO dao= new Tp_cadastroDAO();        
        
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    
    }
}
