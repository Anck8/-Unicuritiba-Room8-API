
package modelo;

public class Banco {

private	int	ID_USUARIO  	;
private	String	NOME        	;
private	String	CPF         	;
private	String	EMAIL       	;
private	String	SENHA       	;
private	String	TP_CADASTRO 	;
private	int	ID_TP_CAD	;
private	String	DESC_CAD 	;
private	int	D_TEL    	;
private	String	TEL       	;
private	int	ID_LUGAR   	;
private	int	USUARIO    	;
private	String	TITULO     	;
private	String	DESCRICAO  	;
private	String	CEP        	;
private	String	ENDERECO   	;
private	String	NUMERO     	;
private	String	COMPLEMENTO	;
private	String	BAIRRO     	;
private	String	CIDADE     	;
private	String	ESTADO     	;
private	String	PONTO_REF  	;
private	String	ID_IMAGEM	;
private	String	LUGAR	        ;
private	String	IMAGEM_1	;

    public Banco(int ID_USUARIO, String NOME, String CPF, String EMAIL, String SENHA, String TP_CADASTRO, int ID_TP_CAD, String DESC_CAD, int D_TEL, String TEL, int ID_LUGAR, int USUARIO, String TITULO, String DESCRICAO, String CEP, String ENDERECO, String NUMERO, String COMPLEMENTO, String BAIRRO, String CIDADE, String ESTADO, String PONTO_REF, String ID_IMAGEM, String LUGAR, String IMAGEM_1) {
        this.ID_USUARIO = ID_USUARIO;
        this.NOME = NOME;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.TP_CADASTRO = TP_CADASTRO;
        this.ID_TP_CAD = ID_TP_CAD;
        this.DESC_CAD = DESC_CAD;
        this.D_TEL = D_TEL;
        this.TEL = TEL;
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
        this.ID_IMAGEM = ID_IMAGEM;
        this.LUGAR = LUGAR;
        this.IMAGEM_1 = IMAGEM_1;
    }

    public Banco(String NOME, String CPF, String EMAIL, String SENHA, String DESC_CAD, String TEL) {
        this.NOME = NOME;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.DESC_CAD = DESC_CAD;
        this.TEL = TEL;
    }

    public Banco(String NOME, String CPF, String EMAIL, String SENHA, int ID_TP_CAD, String TEL) {
        this.NOME = NOME;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.ID_TP_CAD = ID_TP_CAD;
        this.TEL = TEL;
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

    public int getID_TP_CAD() {
        return ID_TP_CAD;
    }

    public void setID_TP_CAD(int ID_TP_CAD) {
        this.ID_TP_CAD = ID_TP_CAD;
    }

    public String getDESC_CAD() {
        return DESC_CAD;
    }

    public void setDESC_CAD(String DESC_CAD) {
        this.DESC_CAD = DESC_CAD;
    }

    public int getD_TEL() {
        return D_TEL;
    }

    public void setD_TEL(int D_TEL) {
        this.D_TEL = D_TEL;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
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

    public String getID_IMAGEM() {
        return ID_IMAGEM;
    }

    public void setID_IMAGEM(String ID_IMAGEM) {
        this.ID_IMAGEM = ID_IMAGEM;
    }

    public String getLUGAR() {
        return LUGAR;
    }

    public void setLUGAR(String LUGAR) {
        this.LUGAR = LUGAR;
    }

    public String getIMAGEM_1() {
        return IMAGEM_1;
    }

    public void setIMAGEM_1(String IMAGEM_1) {
        this.IMAGEM_1 = IMAGEM_1;
    }

 
    
}
