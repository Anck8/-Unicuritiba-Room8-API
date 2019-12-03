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
        "and usuario.id_usuario = telefone.fk_usuario";
        
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
    
    
    public Banco buscar_usuario(Banco banco)
    {
        String sql = "CALL SELECT_USUARIO(?);";
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
                retorno.setTEL(res.getString("TEL"));              
                retorno.setDESC_CAD(res.getString("DESC_CAD"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);   
            
        }
        
        return retorno;
    
    
    }
    
    
    
    public boolean inserir_usuario(Banco banco)
    {
        String sql = "CALL INSERE_USUARIO(?,?,?,?,?,?);";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, banco.getNOME());
            pst.setString(2, banco.getCPF());
            pst.setString(3, banco.getTEL());
            pst.setString(4, banco.getEMAIL());
            pst.setString(5, banco.getSENHA());
            pst.setInt(6, banco.getID_TP_CAD());
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
    
    public boolean atualizar_usuario(Banco banco)
    {
        String sql = "CALL ATUALIZA_USUARIO(?,?,?,?,?,?,?);";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setInt(1, banco.getID_USUARIO());
            pst.setString(2, banco.getNOME());
            pst.setString(3, banco.getCPF());
            pst.setString(4, banco.getTEL());
            pst.setString(5, banco.getEMAIL());
            pst.setString(6, banco.getSENHA());
            pst.setInt(7, banco.getID_TP_CAD());
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
    
    public boolean excluir_usuario(Banco banco) 
    {
        
        String sql = "CALL DELETAR_USUARIO(?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setString(1, banco.getCPF());
            if(pst.executeUpdate()==0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    } 

    public boolean logar (Usuario usuario) 
    {
        String sql = "SELECT * FROM USUARIO where EMAIL=? AND SENHA=?";
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
    
    
    
    
    
    
    /*_______________________________________________*/
    /* crud Lugar */
    
    
     public Banco buscar_lugar_lugar(Banco banco)
    {
        String sql = "CALL SELECT__LUGAR_LUGAR(?);";
         Banco retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setInt(1, banco.getID_LUGAR());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Banco(sql, sql, sql, sql, sql, sql, sql, sql, sql, sql);
                retorno.setTITULO(res.getString("TITULO"));
                retorno.setDESCRICAO(res.getString("DESCRICAO"));
                retorno.setCEP(res.getString("CEP"));
                retorno.setENDERECO(res.getString("ENDERECO"));
                retorno.setNUMERO(res.getString("NUMERO"));
                retorno.setCOMPLEMENTO(res.getString("COMPLEMENTO"));
                retorno.setBAIRRO(res.getString("BAIRRO"));
                retorno.setCIDADE(res.getString("CIDADE"));
                retorno.setESTADO(res.getString("ESTADO"));
                retorno.setPONTO_REF(res.getString("PONTO_REF"));

            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);   
            
        }
        
        return retorno;
    
    
    }
     
     
     
     
     public Banco buscar_lugar_fotos(Banco banco)
    {
        String sql = "CALL SELECT__LUGAR_FOTOS(?);";
         Banco retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setInt(1, banco.getID_LUGAR());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Banco(sql);
                retorno.setIMAGEM_1(res.getString("IMAGEM_1"));
           
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);   
            
        }
        
        return retorno;
    
    
    }
     
     
     public boolean excluir_lugar(Banco banco) 
    {
        
        String sql = "CALL DELETAR_LUGAR(?);";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setInt(1, banco.getID_LUGAR());
            if(pst.executeUpdate()==0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    } 

    
    
    public boolean inserir_lugar(Banco banco)
    {
        String sql = "  CALL INSERE_LUGAR(?,?,?,?,?,?,?,?,?,?,?,?);";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, banco.getTITULO());
            pst.setString(2, banco.getDESCRICAO());
            pst.setString(3, banco.getCEP());
            pst.setString(4, banco.getENDERECO());
            pst.setString(5, banco.getNUMERO());
            pst.setString(6, banco.getCOMPLEMENTO());
            pst.setString(7, banco.getBAIRRO());
            pst.setString(8, banco.getCIDADE());
            pst.setString(9, banco.getESTADO());
            pst.setString(10, banco.getPONTO_REF());
            pst.setString(11, banco.getIMAGEM_1());
            pst.setInt(12, banco.getID_USUARIO());
                 
         
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
    
    
    public boolean atualizar_lugar(Banco banco)
    {
        String sql = "CALL ATUALIZA_LUGAR(?,?,?,?,?,?,?,?,?,?,?);";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setString(1, banco.getTITULO());
            pst.setString(2, banco.getDESCRICAO());
            pst.setString(3, banco.getCEP());
            pst.setString(4, banco.getENDERECO());
            pst.setString(5, banco.getNUMERO());
            pst.setString(6, banco.getCOMPLEMENTO());
            pst.setString(7, banco.getBAIRRO());
            pst.setString(8, banco.getCIDADE());
            pst.setString(9, banco.getESTADO());
            pst.setString(10, banco.getPONTO_REF());
            pst.setInt(11, banco.getID_LUGAR());          
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







