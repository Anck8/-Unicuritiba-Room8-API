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
public class Fotos {
    
    
private int ID_IMAGEM;
private int LUGAR;
private String IMAGEM_1;
private String IMAGEM_2;
private String IMAGEM_3;
private String IMAGEM_4;

    public Fotos() {
    }



    public Fotos(int LUGAR, String IMAGEM_1, String IMAGEM_2, String IMAGEM_3, String IMAGEM_4) {
        this.LUGAR = LUGAR;
        this.IMAGEM_1 = IMAGEM_1;
        this.IMAGEM_2 = IMAGEM_2;
        this.IMAGEM_3 = IMAGEM_3;
        this.IMAGEM_4 = IMAGEM_4;
    }



    public Fotos(int ID_IMAGEM, int LUGAR, String IMAGEM_1, String IMAGEM_2, String IMAGEM_3, String IMAGEM_4) {
        this.ID_IMAGEM = ID_IMAGEM;
        this.LUGAR = LUGAR;
        this.IMAGEM_1 = IMAGEM_1;
        this.IMAGEM_2 = IMAGEM_2;
        this.IMAGEM_3 = IMAGEM_3;
        this.IMAGEM_4 = IMAGEM_4;
    }



    public String getIMAGEM_2() {
        return IMAGEM_2;
    }

    public void setIMAGEM_2(String IMAGEM_2) {
        this.IMAGEM_2 = IMAGEM_2;
    }

    public String getIMAGEM_3() {
        return IMAGEM_3;
    }

    public void setIMAGEM_3(String IMAGEM_3) {
        this.IMAGEM_3 = IMAGEM_3;
    }

    public String getIMAGEM_4() {
        return IMAGEM_4;
    }

    public void setIMAGEM_4(String IMAGEM_4) {
        this.IMAGEM_4 = IMAGEM_4;
    }





    public int getID_IMAGEM() {
        return ID_IMAGEM;
    }

    public void setID_IMAGEM(int ID_IMAGEM) {
        this.ID_IMAGEM = ID_IMAGEM;
    }

    public int getLUGAR() {
        return LUGAR;
    }

    public void setLUGAR(int LUGAR) {
        this.LUGAR = LUGAR;
    }

    public String getIMAGEM_1() {
        return IMAGEM_1;
    }

    public void setIMAGEM_1(String IMAGEM_1) {
        this.IMAGEM_1 = IMAGEM_1;
    }

}
