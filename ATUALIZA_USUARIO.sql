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
IN ID_TP_CAD  CHAR    (2)
)
BEGIN

  DECLARE NOME_       VARCHAR (100) ;
  DECLARE CPF_        VARCHAR (15)  ;
  DECLARE TEL_        VARCHAR (15)  ;
  DECLARE EMAIL_      VARCHAR (100) ;
  DECLARE SENHA_      VARCHAR (100) ;
  DECLARE ID_TP_CAD_ CHAR    (2)   ;
  DECLARE ID_         INT     (5)   ;
  
  SET @NOME_       = NOME        ;
  SET @CPF_        = CPF         ;
  SET @EMAIL_      = EMAIL       ;
  SET @SENHA_      =  SENHA      ;
  SET @ID_TP_CAD_ = ID_TP_CAD ;
  SET @TEL_        = TEL         ;
  SET @ID_         = ID          ;

  UPDATE USUARIO 
  SET 
    NOME        = @NOME_      ,
    CPF         = @CPF_       ,
    EMAIL       = @EMAIL_     ,
    SENHA       = @SENHA_     ,
    TP_CADASTRO = @ID_TP_CAD_
  WHERE 
    USUARIO.ID_USUARIO = @ID_    ;
    
  UPDATE TELEFONE
  SET 
    TEL = @TEL_
  WHERE 
    FK_USUARIO = @ID_         ; 
     
END$$
DELIMITER ;

/*
CALL ATUALIZA_USUARIO(
  2,
  'NOVO'     ,
  '856' ,
  '777',
  'NOVO@TESTE',
  'NOVO'       ,
  1
  );
  
  select * from usuario
*/

