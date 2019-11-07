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
import modelo.Tp_cadastro;
import modelo.Usuario;


public class Tp_cadastroDAO {
   
    
     public Tp_cadastroDAO()
    {
        
        
    }
     
     
      public List<Tp_cadastro> listar()
    {
         String sql = "SELECT * FROM TP_CADASTRO";
        ArrayList<Tp_cadastro> retorno = new ArrayList<Tp_cadastro>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Tp_cadastro item = new Tp_cadastro();
                item.setID_TP_CAD(res.getInt("ID_TP_CAD"));
                item.setDESC_CAD(res.getString("DESC_CAD"));                        

                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
     
}
