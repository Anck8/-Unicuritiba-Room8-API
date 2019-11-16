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
import modelo.Banco;
import modelo.Telefone;
import modelo.Usuario;


public class UsuarioDAO {
    
    
    public UsuarioDAO()
    {
    
    }
       
   
       
    public List<Banco> listar()
    {
         String sql = 
        "select \n" +
        "usuario.nome,\n" +
        "usuario.cpf,\n" +
        "usuario.email,\n" +
        "usuario.senha,\n" +
        "telefone.tel,\n" +
        "tp_cadastro.desc_cad\n" +
        "from usuario " +
        "inner join telefone " + 
        "inner join tp_cadastro " + 
        "on tp_cadastro.ID_TP_CAD = usuario.tp_cadastro \n" +
        "and usuario.id_usuario = telefone.usuario";
        
        List<Banco> retorno = new ArrayList<Banco>();

        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Banco item = new Banco(sql, sql, sql, sql, sql, sql);
                item.setNOME(res.getString("NOME")); 
                item.setCPF(res.getString("CPF"));              
                item.setEMAIL(res.getString("EMAIL"));              
                item.setSENHA(res.getString("SENHA"));              
                item.setTEL(res.getString("tel"));              
                item.setDESC_CAD(res.getString("DESC_CAD"));              

                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Banco buscar(Banco banco)
    {
        String sql = "select \n" +
        "usuario.nome,\n" +
        "usuario.cpf,\n" +
        "usuario.email,\n" +
        "usuario.senha,\n" +
        "telefone.tel,\n" +
        "tp_cadastro.desc_cad\n" +
        "from usuario\n" +
        "inner join telefone\n" +
        "inner join tp_cadastro\n" +
        "on tp_cadastro.ID_TP_CAD = usuario.tp_cadastro \n" +
        "and usuario.id_usuario = telefone.usuario \n" +
        "where usuario.cpf = ? ;";
         Banco retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setString(1, banco.getCPF());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Banco(sql, sql, sql, sql, sql, sql);
                retorno.setNOME(res.getString("NOME"));
                retorno.setCPF(res.getString("CPF"));
                retorno.setEMAIL(res.getString("EMAIL"));
                retorno.setSENHA(res.getString("SENHA"));
                retorno.setTEL(res.getString("tel"));              
                retorno.setDESC_CAD(res.getString("DESC_CAD"));
                
                
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

    public boolean logar (Usuario usuario) {
        String sql = "SELECT * FROM USUARIO where EMAIL=? AND NOME=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getEMAIL());
            pst.setString(2, usuario.getSENHA());
            ResultSet res = pst.executeQuery();
            if(res.next()) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    } 
}
