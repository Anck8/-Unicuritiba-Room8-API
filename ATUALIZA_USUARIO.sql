USE ROOM8;
DROP PROCEDURE IF EXISTS ATUALIZA_USUARIO;
DELIMITER $$


CREATE PROCEDURE ATUALIZA_USUARIO(
IN ID          INT      (5)  ,
IN NOME        VARCHAR (100) ,
IN CPF         VARCHAR (15)  ,
IN TEL         VARCHAR (15)  ,
IN EMAIL       VARCHAR (100) ,
IN SENHA       VARCHAR (100) ,
IN TP_CADASTRO  CHAR    (2)
)
BEGIN

  DECLARE NOME_       VARCHAR (100) ;
  DECLARE CPF_        VARCHAR (15)  ;
  DECLARE TEL_        VARCHAR (15)  ;
  DECLARE EMAIL_      VARCHAR (100) ;
  DECLARE SENHA_      VARCHAR (100) ;
  DECLARE TPCADASTRO_ CHAR    (2)   ;
  DECLARE ID_         INT     (5)   ;
  
  SET @NOME_       = NOME        ;
  SET @CPF_        = CPF         ;
  SET @EMAIL_      = EMAIL       ;
  SET @SENHA_      =  SENHA      ;
  SET @TPCADASTRO_ = TP_CADASTRO ;
  SET @TEL_        = TEL         ;
  SET @ID_         = ID          ;

  UPDATE USUARIO 
  SET 
    NOME        = @NOME_      ,
    CPF         = @CPF_       ,
    EMAIL       = @EMAIL_     ,
    SENHA       = @SENHA_     ,
    TP_CADASTRO = @TPCADASTRO_
  WHERE 
    USUARIO.CPF = @ID_        ;
    
  UPDATE TELEFONE
  SET 
    TEL = @TEL_
  WHERE 
    FK_USUARIO = @ID_         ; 
     
END$$
DELIMITER ;

/*
CALL ATUALIZA_USUARIO(
  3,
  'NOVO'     ,
  '1' ,
  '777',
  'NOVO@TESTE',
  'NOVO'       ,
  1
  );
*/

