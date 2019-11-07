/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;


public class UsuarioDAO {

    
    public UsuarioDAO()
    {
    
    }    

   
       
    public List<Usuario> listar()
    {
         String sql = "SELECT * FROM USUARIO";
        List<Usuario> retorno = new ArrayList<Usuario>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Usuario item = new Usuario(0, sql, sql, sql, sql, sql);
                item.setID_USUARIO(res.getInt("ID_USUARIO"));
                item.setNOME(res.getString("NOME")); 
                item.setCPF(res.getString("CPF"));              
                item.setEMAIL(res.getString("EMAIL"));              
                item.setSENHA(res.getString("SENHA"));              
                item.setTP_CADASTRO(res.getString("TP_CADASTRO"));              

                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Usuario buscar(Usuario usuario)
    {
         String sql = "SELECT * FROM USUARIO where ID_USUARIO = ?";
        Usuario retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setInt(1, usuario.getID_USUARIO());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Usuario(0, sql, sql, sql, sql, sql);
                retorno.setID_USUARIO(res.getInt("ID_USUARIO"));
                retorno.setNOME(res.getString("NOME"));
                retorno.setCPF(res.getString("CPF"));
                retorno.setEMAIL(res.getString("EMAIL"));
                retorno.setSENHA(res.getString("SENHA"));
                retorno.setTP_CADASTRO(res.getString("TP_CADASTRO"));

                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public boolean inserir(Usuario usuario)
    {
        String sql = "INSERT INTO USUARIO(NOME,CPF,EMAIL,SENHA,TP_CADASTRO) VALUES(?,?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNOME());
            pst.setString(2, usuario.getCPF());
            pst.setString(3, usuario.getEMAIL());
            pst.setString(4, usuario.getSENHA());
            pst.setString(5, usuario.getTP_CADASTRO());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Usuario usuario)
    {
        String sql = "UPDATE USUARIO set NOME=?,CPF=?,EMAIL=?,SENHA=?,TP_CADASTRO=? where CPF=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setString(1, usuario.getNOME());
            pst.setString(2, usuario.getCPF());
            pst.setString(3, usuario.getEMAIL());
            pst.setString(4, usuario.getSENHA());
            pst.setString(5, usuario.getTP_CADASTRO());
            pst.setString(6, usuario.getCPF());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Usuario usuario) 
    {
        
        String sql = "DELETE FROM USUARIO where ID_USUARIO=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setInt(1, usuario.getID_USUARIO());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    } 


}
