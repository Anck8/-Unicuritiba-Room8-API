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
public class Telefone {
    
 private int ID_TEL;     
 private int USUARIO;    
 private String TEL_FIXO;   
 private String TEL_CELULAR;

    public int getID_TEL() {
        return ID_TEL;
    }

    public void setID_TEL(int ID_TEL) {
        this.ID_TEL = ID_TEL;
    }

    public int getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(int USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getTEL_FIXO() {
        return TEL_FIXO;
    }

    public void setTEL_FIXO(String TEL_FIXO) {
        this.TEL_FIXO = TEL_FIXO;
    }

    public String getTEL_CELULAR() {
        return TEL_CELULAR;
    }

    public void setTEL_CELULAR(String TEL_CELULAR) {
        this.TEL_CELULAR = TEL_CELULAR;
    }

    
}
