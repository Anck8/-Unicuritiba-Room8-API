DROP PROCEDURE IF EXISTS INSERE_USUARIO;
DELIMITER $$

CREATE PROCEDURE INSERE_USUARIO(
IN ID_USUARIO  INT     (5)   ,
IN NOME        VARCHAR (100) ,
IN CPF         VARCHAR (15)  ,
IN TEL         VARCHAR (15)  ,
IN EMAIL       VARCHAR (100) ,
IN SENHA       VARCHAR (100) ,
IN TPCADASTRO  CHAR    (2)
)
BEGIN

  DECLARE IDUSUARIO  INT     (5)   ;
  DECLARE NOME       VARCHAR (100) ;
  DECLARE CPF        VARCHAR (15)  ;
  DECLARE TEL        VARCHAR (15)  ;
  DECLARE EMAIL      VARCHAR (100) ;
  DECLARE SENHA      VARCHAR (100) ;
  DECLARE TPCADASTRO CHAR    (2)   ;

  SET @NOME       = NOME        ;
  SET @CPF        = CPF         ;
  SET @TEL        = TEL         ;
  SET @EMAIL      = EMAIL       ;
  SET @SENHA_     = SENHA       ;
  SET @TPCADASTRO = TP_CADASTRO ;

  INSERT INTO USUARIO (
    ID_USUARIO  ,
    NOME        ,
    CPF         ,
    EMAIL       ,
    SENHA       ,
    TP_CADASTRO 
    )
  VALUES(
    IDUSUARIO ,
    @NOME     ,
    @CPF      ,
    @EMAIL    ,
    @SENHA    ,
    @TPCADASTRO
    );

  SET @IDUSUARIO = (SELECT IDUSUARIO FROM USUARIO WHERE USUARIO.CPF = CPF);

  SELECT 
    @IDUSUARIO  ,
    @NOME       ,
    @CPF        ,
    @TEL        ,
    @EMAIL      ,
    @SENHA      ,
    @TPCADASTRO ;

END$$
DELIMITER ;