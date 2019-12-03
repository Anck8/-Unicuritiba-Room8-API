USE ROOM8;
DROP PROCEDURE IF EXISTS INSERE_USUARIO;
DELIMITER $$

CREATE PROCEDURE INSERE_USUARIO(
IN NOME        VARCHAR (100) ,
IN CPF         VARCHAR (15)  ,
IN TEL         VARCHAR (15)  ,
IN EMAIL       VARCHAR (100) ,
IN SENHA       VARCHAR (100) ,
IN ID_TP_CAD  INT   (2)
)
BEGIN

  DECLARE ID_         INT     (5)   ;
  DECLARE NOME_       VARCHAR (100) ;
  DECLARE CPF_        VARCHAR (15)  ;
  DECLARE TEL_        VARCHAR (15)  ;
  DECLARE EMAIL_      VARCHAR (100) ;
  DECLARE SENHA_      VARCHAR (100) ;
  DECLARE ID_TP_CAD_ INT    (2)   ;

  SET @NOME_       = NOME        ;
  SET @CPF_        = CPF         ;
  SET @TEL_        = TEL         ;
  SET @EMAIL_      = EMAIL       ;
  SET @SENHA_      = SENHA       ;
  SET @ID_TP_CAD_ = ID_TP_CAD;
  
  INSERT INTO USUARIO (
    ID_USUARIO  ,
    NOME        ,
    CPF         ,
    EMAIL       ,
    SENHA       ,
    TP_CADASTRO 
    )
  VALUES(
    NULL         ,
    @NOME_       , 
    @CPF_        ,
    @EMAIL_      ,
    @SENHA_      ,
    @ID_TP_CAD_
    )            ;


  SET @ID_ = (SELECT ID_USUARIO FROM USUARIO WHERE USUARIO.CPF = CPF);
  
  INSERT INTO TELEFONE(
    ID_TEL,
    FK_USUARIO,
    TEL
    )
  
  VALUES(
    NULL,
    @ID_,
    @TEL_
    );
  
  
  
END$$
DELIMITER ;

/*

CALL INSERE_USUARIO(
  'LUCAS'     ,
  '7' ,
  '419999',
  'LUCAS@LUCAS',
  '123'       ,
  1
);

select * from usuario
SELECT * FROM TELEFONE

*/




