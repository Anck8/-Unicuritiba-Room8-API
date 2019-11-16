/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author marcelosiedler
 */
public class Usuario {
    
    private int ID_USUARIO;
    private String NOME;
    private String CPF;
    private String EMAIL;
    private String SENHA;
    private String TP_CADASTRO;

    public Usuario(int ID_USUARIO, String NOME, String CPF, String EMAIL, String SENHA, String TP_CADASTRO) {
        this.ID_USUARIO = ID_USUARIO;
        this.NOME = NOME;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.TP_CADASTRO = TP_CADASTRO;
    }

    public Usuario() {
    }

    public Usuario(String NOME, String CPF, String EMAIL, String SENHA, String TP_CADASTRO) {
        this.NOME = NOME;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.TP_CADASTRO = TP_CADASTRO;
    }

    public Usuario(String EMAIL, String SENHA) {
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
    }

    
    
    
    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    public String getTP_CADASTRO() {
        return TP_CADASTRO;
    }

    public void setTP_CADASTRO(String TP_CADASTRO) {
        this.TP_CADASTRO = TP_CADASTRO;
    }


    
    
    
}
