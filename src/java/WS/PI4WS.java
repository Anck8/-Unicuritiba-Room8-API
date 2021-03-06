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
import modelo.Fotos;
import modelo.Lugar;
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



    //(OK)
    //Select all
    //Select que retorna informações de todos os Usuarios cadastrados
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/todos")
    public String listar(){
    
        List<Banco> lista; 
        UsuarioDAO dao= new UsuarioDAO();
        Banco u = new Banco();
        lista = dao.listar();

        Gson g = new Gson();
        
        return g.toJson(lista);
        
    }
    
    
    
    //(OK)
    //Select que retorna informações de um Usuario
    //passando cpf como where
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/where/{cpf}")
    public String buscar(@PathParam("cpf") String cpf)
    {
        Banco u = new Banco(cpf);
        u.setCPF(cpf);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar_usuario(u);
        
        Gson g = new Gson();       
        return g.toJson(u);    
    }
    
    
    
    //(OK)
    //Select que retornta false ou true,
    //passando e-mail e senha no where.   
    //Usado para validar o login 
    @GET
    @Path("Usuario/get/logar/{email}/{senha}")
    public boolean logar(@PathParam("email") String email,@PathParam("senha") String senha)
    {
        Usuario u = new Usuario(email, senha);
        u.setEMAIL(email);
        u.setSENHA(senha);        
        UsuarioDAO dao = new UsuarioDAO();
        dao.logar(u);
        return dao.logar(u);   
    
    }
    
    
    
    //(OK)
    //delete Usuario  com where cpf
    @GET
    @Path("Usuario/excluir/{cpf}")
    public boolean excluir (@PathParam("cpf")String cpf)
    {        
        
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.excluir_usuario(cpf); 
        
    }
    
    
    
       
    //(OK)
    //Insert tabela Usuario e Telefone
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("Usuario/inserir")
    public boolean inserir_usuario(String content){
        Gson g = new Gson();
        Banco u = (Banco) g.fromJson(content, Banco.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.inserir_usuario(u);
    }

       
    //(OK)
    //Atualiza usuario
    //passa um Jsom com os dados atualizados Usuario
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("Usuario/alterar")
    public boolean alterar(String content){
        Gson g = new Gson();
        Banco u = (Banco) g.fromJson(content, Banco.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.atualizar_usuario(u);
    }
    
    
    
    
    /*______________________________________________*/
    /*CRUD Lugar*/
    
    
    
    
    //(Verificar)
    //Visualizar todos os lugares cadastrados pelo usuario
    //(tabela lugar)
    //passa id_usuario
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Lugar/get/where/lugar/{id_usuario}")
    public String buscar_lugar(@PathParam("id_usuario") int id_usuario)
    {
        ArrayList<Lugar> u = new ArrayList<>();
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar_lugar_lugar(id_usuario);
        
        Gson g = new Gson();       
        return g.toJson(u);    
    }
    
    
    
    
    //(ok)
    //retorna as fotos do local passando id_lugar
    //(tabela lugar)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Lugar/get/where/fotos/{id_lugar}")
    public String buscar_lugar_fotos(@PathParam("id_lugar") int id_lugar)
    {
        ArrayList<Fotos> u = new ArrayList<Fotos>();
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar_lugar_fotos(id_lugar);
        
        Gson g = new Gson();       
        return g.toJson(u);    
    }
    
    
    
    
    
    
    //(OK)
    //delete com where. Lugar e Fotos
    @GET
    @Path("Lugar/excluir/{id_lugar}")
    public boolean excluir_lugar (@PathParam("id_lugar")int id_lugar)
    {        
        
        Banco u = new Banco(id_lugar);
        u.setID_LUGAR(id_lugar);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.excluir_lugar(u); 
        
    }
    
    
    
    
    
    //(OK)
    //Insert tabela Lugar
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("Lugar/inserir")
    public boolean inserir_lugar(String content){
        Gson g = new Gson();
        Banco u = (Banco) g.fromJson(content, Banco.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.inserir_lugar(u);
    }
    
    
    
    //Atualiza tabela lugar
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("Lugar/alterar")
    public boolean alterar_lugar(String content){
        Gson g = new Gson();
        Banco u = (Banco) g.fromJson(content, Banco.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.atualizar_lugar(u);
    }
    
    
    
 
    

    
    
    
    
    //(OK)
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
