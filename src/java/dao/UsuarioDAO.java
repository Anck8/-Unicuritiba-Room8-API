/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import com.google.gson.JsonObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Banco;
import modelo.Fotos;
import modelo.Lugar;
import modelo.Retorno;
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
                Banco item = new Banco(sql);
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
                retorno = new Banco(sql);
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
    
    
    
    public  Retorno inserir_usuario(Banco banco)
    {                   
        Retorno retorno = new Retorno();
        JsonObject jsonObject = new JsonObject();
        String sql = "CALL INSERE_USUARIO(?,?,?,?,?,?);";
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

            retorno = new Retorno();
                retorno.setRETORNO("inserido");       }
                
            
            
        } catch (SQLException ex) {
                retorno.setRETORNO("erro");
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
    
    public boolean excluir_usuario(String  cpf) 
    {
        
        String sql = "CALL DELETAR_USUARIO(?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setString(1,cpf);
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

    public Usuario logar (Usuario usuario) 
    {
        String sql = "SELECT * FROM USUARIO where EMAIL=? AND SENHA=?";
         Usuario retorno = null;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getEMAIL());
            pst.setString(2, usuario.getSENHA());
            ResultSet res = pst.executeQuery();
            if(res.next()) {
                
                
                retorno = new Usuario();
                retorno.setID_USUARIO(res.getInt("ID_USUARIO"));
                retorno.setNOME(res.getString("NOME"));
                retorno.setCPF(res.getString("CPF"));
                retorno.setEMAIL(res.getString("EMAIL"));
                retorno.setSENHA(res.getString("SENHA"));
                retorno.setTP_CADASTRO(res.getString("TP_CADASTRO"));

                
                            }
            else {retorno=null;}
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    } 
    
    
    
    
    
    
    /*_______________________________________________*/
    /* crud Lugar */
    
    /*Verificar */
     public ArrayList <Lugar> buscar_lugar_lugar(int  id_usuario)
    {
        String sql = "CALL SELECT__LUGAR_LUGAR(?);";
        ArrayList<Lugar> lugares = new ArrayList();
         Lugar retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, id_usuario);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                retorno = new Lugar();
                retorno.setID_LUGAR(res.getInt("ID_LUGAR"));
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

                lugares.add(retorno);
            }



        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lugares;
    }
     
     
     
     
     public ArrayList<Fotos> buscar_lugar_fotos(int  id_lugar)
    {
        String sql = "CALL SELECT__LUGAR_FOTOS(?);";
                ArrayList<Fotos> fotos = new ArrayList();
 
        Fotos retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setInt(1, id_lugar);
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                retorno = new Fotos();
                retorno.setIMAGEM_1(res.getString("IMAGEM_1"));
           fotos.add(retorno);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);   
            
        }
        
        return fotos;
    
    
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

    
    
    public Retorno inserir_lugar(Banco banco)
    {
        String sql = "  CALL INSERE_LUGAR(?,?,?,?,?,?,?,?,?,?,?,?);";
        Retorno retorno = new Retorno();
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
               retorno = new Retorno();
                retorno.setRETORNO("inserido"); 
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                            retorno.setRETORNO("erro"); 

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
    
    
    
    
    public Retorno inserir_fotos (Fotos fotos)
    {
        String sql = "  CALL INSERE_LUGAR_FOTOS(?,?,?,?);";
        Retorno retorno = new Retorno();
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, fotos.getIMAGEM_1());
            pst.setString(2, fotos.getIMAGEM_2());
            pst.setString(3, fotos.getIMAGEM_3());
            pst.setString(4, fotos.getIMAGEM_4());
            
            
            if(pst.executeUpdate()>0)
            {
               retorno = new Retorno();
                retorno.setRETORNO("inserido"); 
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                            retorno.setRETORNO("erro"); 

        }
        
        return retorno;
    
    }   
    
    
    
  public ArrayList<Banco> buscar_lugar_feed()
    {
        String sql = "CALL SELECT_FEED;";
                ArrayList<Banco> banco = new ArrayList();
 
        Banco retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                retorno = new Banco();
                retorno.setID_LUGAR(res.getInt("ID_LUGAR"));
                retorno.setTITULO(res.getString("TITULO"));
                retorno.setDESCRICAO(res.getString("DESCRICAO"));               
                retorno.setIMAGEM_1(res.getString("IMAGEM_1"));
           banco.add(retorno);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);   
            
        }
        
        return banco;
    
    
    }
    
}







