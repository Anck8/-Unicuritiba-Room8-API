/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jeanL
 */
public class Lugar {
    
private int ID_LUGAR;  
private int USUARIO;    
private String TITULO;     
private String DESCRICAO ; 
private String CEP;        
private String ENDERECO ;  
private String NUMERO;     
private String COMPLEMENTO;
private String BAIRRO;  
private String CIDADE;   
private String ESTADO;  
private String PONTO_REF; 

    public Lugar() {
    }

  

  

    public int getID_LUGAR() {
        return ID_LUGAR;
    }

    public void setID_LUGAR(int ID_LUGAR) {
        this.ID_LUGAR = ID_LUGAR;
    }

    public int getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(int USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getENDERECO() {
        return ENDERECO;
    }

    public void setENDERECO(String ENDERECO) {
        this.ENDERECO = ENDERECO;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getCOMPLEMENTO() {
        return COMPLEMENTO;
    }

    public void setCOMPLEMENTO(String COMPLEMENTO) {
        this.COMPLEMENTO = COMPLEMENTO;
    }

    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public String getCIDADE() {
        return CIDADE;
    }

    public void setCIDADE(String CIDADE) {
        this.CIDADE = CIDADE;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getPONTO_REF() {
        return PONTO_REF;
    }

    public void setPONTO_REF(String PONTO_REF) {
        this.PONTO_REF = PONTO_REF;
    }

    public Lugar(int ID_LUGAR, int USUARIO, String TITULO, String DESCRICAO, String CEP, String ENDERECO, String NUMERO, String COMPLEMENTO, String BAIRRO, String CIDADE, String ESTADO, String PONTO_REF) {
        this.ID_LUGAR = ID_LUGAR;
        this.USUARIO = USUARIO;
        this.TITULO = TITULO;
        this.DESCRICAO = DESCRICAO;
        this.CEP = CEP;
        this.ENDERECO = ENDERECO;
        this.NUMERO = NUMERO;
        this.COMPLEMENTO = COMPLEMENTO;
        this.BAIRRO = BAIRRO;
        this.CIDADE = CIDADE;
        this.ESTADO = ESTADO;
        this.PONTO_REF = PONTO_REF;
    }

   

    
    
    
}
