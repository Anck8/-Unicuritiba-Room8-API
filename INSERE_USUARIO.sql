USE ROOM8;
DROP PROCEDURE IF EXISTS INSERE_USUARIO;
DELIMITER $$

CREATE PROCEDURE INSERE_USUARIO(
IN ID_USUARIO_  INT             (5)   ,
IN NOME        VARCHAR (100) ,
IN CPF         VARCHAR (15)  ,
IN TEL         VARCHAR (15)  ,
IN EMAIL       VARCHAR (100) ,
IN SENHA       VARCHAR (100) ,
IN TP_CADASTRO  CHAR    (2)
)
BEGIN

  DECLARE ID_  INT     (5)   ;
  DECLARE NOME_       VARCHAR (100) ;
  DECLARE CPF_        VARCHAR (15)  ;
  DECLARE TEL_        VARCHAR (15)  ;
  DECLARE EMAIL_      VARCHAR (100) ;
  DECLARE SENHA_      VARCHAR (100) ;
  DECLARE TPCADASTRO_ CHAR    (2)   ;

  SET @NOME_       = NOME        ;
  SET @CPF_        = CPF         ;
  SET @TEL_        = TEL         ;
  SET @EMAIL_      = EMAIL       ;
  SET @SENHA_     =  SENHA        ;
  SET @TPCADASTRO_ = TP_CADASTRO  ;
  
  INSERT INTO USUARIO (
    ID_USUARIO  ,
    NOME        ,
    CPF         ,
    EMAIL       ,
    SENHA       ,
    TP_CADASTRO 
    )
  VALUES(
    null ,
    @NOME_     ,
    @CPF_      ,
    @EMAIL_    ,
    @SENHA_    ,
    @TPCADASTRO_
    );


  SET @ID_ = (SELECT ID_USUARIO FROM USUARIO WHERE USUARIO.CPF = CPF);
  
  INSERT INTO TELEFONE(
    ID_TEL,
    FK_USUARIO,
    TEL
    )
  
  VALUES(
    NULL,
    @ID_,
    @TEL
    );
 
 
 
  /*
  SELECT 
	@ID_  ,
    @NOME_       ,
    @CPF_        ,
    @TEL_        ,
    @EMAIL_      ,
    @SENHA_      ,
    @TPCADASTRO_ ;
  */
END$$
DELIMITER ;


/*
CALL INSERE_USUARIO(
  NULL        ,
  'LUCAS'     ,
  '5' ,
  '419999',
  'LUCAS@LUCAS',
  '123'       ,
  1
);*/



