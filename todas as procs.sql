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

/*_______________________________________________*/

DROP PROCEDURE IF EXISTS DELETAR_USUARIO;
DELIMITER $$

CREATE PROCEDURE DELETAR_USUARIO(IN CPF VARCHAR(15))
BEGIN
  DECLARE CPF_ VARCHAR (15) ;
  DECLARE ID   VARCHAR (15) DEFAULT NULL;
  DECLARE ID_FOTO VARCHAR (15) DEFAULT NULL;

  IF  EXISTS 
  (    
    SELECT * FROM USUARIO WHERE USUARIO.CPF = CPF
  )
  THEN
    SET @ID      = (SELECT ID_USUARIO FROM USUARIO WHERE USUARIO.CPF   = CPF) ;
    SET @ID_FOTO = (SELECT ID_LUGAR   FROM  LUGAR WHERE LUGAR.FK_USUARIO = @ID LIMIT 1) ;  
    DELETE FROM USUARIO  WHERE ID_USUARIO = @ID;
    DELETE FROM TELEFONE WHERE FK_USUARIO = @ID;
    
    
  END IF; 
   
  IF EXISTS 
  (
    SELECT ID_LUGAR FROM  LUGAR WHERE FK_USUARIO = @ID
  ) 
  THEN
    DELETE FROM FOTOS WHERE FOTOS.FK_LUGAR = @ID_FOTO ;
    DELETE FROM LUGAR WHERE FK_USUARIO     = @ID      ;  
END IF; 


END$$
DELIMITER ;

/*
call DELETAR_USUARIO(4545454)
select * from telefone
select * from fotos
SELECT * FROM USUARIO;
select * from lugar
*/




/*_______________________________________________*/

DROP PROCEDURE IF EXISTS SELECT_USUARIO;
DELIMITER $$

CREATE PROCEDURE SELECT_USUARIO(
IN CPF VARCHAR(15)
)
BEGIN

  DECLARE CPF_ VARCHAR(15) ;

  SELECT
    USUARIO.NOME ,
    USUARIO.CPF  ,
    USUARIO.EMAIL,
    USUARIO.SENHA,
    TELEFONE.TEL ,
    TP_CADASTRO.DESC_CAD
  FROM 
    USUARIO 
  LEFT JOIN 
    TELEFONE
  ON 
    (USUARIO.ID_USUARIO = TELEFONE.FK_USUARIO)
  LEFT JOIN TP_CADASTRO
  ON 
    (TP_CADASTRO.ID_TP_CAD = USUARIO.TP_CADASTRO)
  WHERE  USUARIO.CPF = CPF;
        

END$$
DELIMITER ;

/*
CALL SELECT_USUARIO(4545454);

SELECT * FROM TP_CADASTRO;
select * from telefone
SELECT * FROM USUARIO;
select * from lugar

        */
  
  
  
  
  
  
  

  
/*_______________________________________________*/

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





/*_______________________________________________*/

USE ROOM8;
DROP PROCEDURE IF EXISTS INSERE_LUGAR;
DELIMITER $$

CREATE PROCEDURE INSERE_LUGAR(
IN TITULO         VARCHAR(150)   , 
IN DESCRICAO      VARCHAR(255)   , 
IN CEP            VARCHAR(10)    ,
IN ENDERECO       VARCHAR(255)   ,
IN NUMERO         VARCHAR(20)    ,
IN COMPLEMENTO    VARCHAR(60)    , 
IN BAIRRO         VARCHAR(60)    ,
IN CIDADE         VARCHAR(60)    ,
IN ESTADO         CHAR(2)        ,
IN PONTO_REF      VARCHAR(60)    ,
IN IMAGEM_1       LONGBLOB   ,          

IN FK_USUARIO     INT(5)          

)
BEGIN 
  DECLARE  TITULO_         VARCHAR(150) ;   
  DECLARE  DESCRICAO_      VARCHAR(255) ;
  DECLARE  CEP_            VARCHAR(10)  ;
  DECLARE  ENDERECO_       VARCHAR(255) ;
  DECLARE  NUMERO_         VARCHAR(20)  ; 
  DECLARE  COMPLEMENTO_    VARCHAR(60)  ;
  DECLARE  BAIRRO_         VARCHAR(60)  ;
  DECLARE  CIDADE_         VARCHAR(60)  ;
  DECLARE  ESTADO_         CHAR(2)      ; 
  DECLARE  PONTO_REF_      VARCHAR(60) ;  
  DECLARE  ID_USUARIO_     INT(5)      ;  
  DECLARE  ID_IMAGEM_      INT(5)      ;     
  DECLARE  FK_LUGAR_       INT(5)      ;

  SET @TITULO_      = TITULO           ;
  SET @DESCRICAO_   = DESCRICAO        ;
  SET @CEP_         = CEP              ;
  SET @ENDERECO_    = ENDERECO         ;
  SET @NUMERO_      = NUMERO           ;
  SET @COMPLEMENTO_ = COMPLEMENTO;
  SET @BAIRRO_      = BAIRRO     ;
  SET @CIDADE_      = CIDADE     ;
  SET @ESTADO_      = ESTADO    ;
  SET @PONTO_REF_   = PONTO_REF ;
  SET @IMAGEM_1_    = IMAGEM_1         ;


SET @FK_USUARIO_  = FK_USUARIO       ;

  
  INSERT INTO LUGAR(
    ID_LUGAR      ,
    TITULO        ,
    DESCRICAO     ,
    CEP ,
    ENDERECO      ,
    NUMERO   ,
    COMPLEMENTO   ,
    BAIRRO        ,
    CIDADE     , 
    ESTADO        ,
    PONTO_REF     ,
   FK_USUARIO
   )
  
  VALUES(
    NULL         ,
    @TITULO_     , 
	@DESCRICAO_  ,
    @CEP_      ,  
    @ENDERECO_   ,
    @NUMERO_     ,
    @COMPLEMENTO_,
    @BAIRRO_     , 
    @CIDADE_     ,
    @ESTADO_     ,
    @PONTO_REF_  ,
    @FK_USUARIO_ 

    )            ;
 
   SET @FK_LUGAR_ = LAST_INSERT_ID();




INSERT INTO FOTOS(
    ID_IMAGEM      ,
    IMAGEM_1       ,
    FK_LUGAR  
    )
 
  VALUES(
    NULL       ,
    @IMAGEM_1_ ,
    @FK_LUGAR_
    );




  END$$
  DELIMITER ;
  
  /*
  
  CALL INSERE_LUGAR(   
  '1111 121212',
  'NOVA Insert2',
  '94493',
  'Rua NOVA ',
  '123',
  'Casa NOVA',
  'Centro ',
  'CTB 2',
  'SP',
  'Mercado NOVA',
  1,
  1
);
  

  select * from usuario
  
  SELECT * FROM LUGAR;
  SELECT * FROM FOTOS;
  */
  
  
  
  
  /*_______________________________________________*/

DROP PROCEDURE IF EXISTS DELETAR_LUGAR;
DELIMITER $$

CREATE PROCEDURE DELETAR_LUGAR(
IN ID_LUGAR VARCHAR(15)
)  
BEGIN

  DECLARE ID_LUGAR_ VARCHAR(15) ;
 
  SET     @ID_LUGAR_ = ID_LUGAR ;

  DELETE FROM LUGAR WHERE LUGAR.ID_LUGAR =  @ID_LUGAR_ ;
  
  DELETE FROM FOTOS WHERE FOTOS.FK_LUGAR =  @ID_LUGAR_ ;

END$$
DELIMITER ;


/*
CALL DELETAR_LUGAR(3);

SELECT * FROM LUGAR;
UPDATE LUGAR SET LUGAR.PONTO_REF = NULL  WHERE ID_LUGAR = 15; 

SELECT * FROM FOTOS;
SELECT * FROM USUARIO;
SELECT * FROM TELEFONE;*/

  
  
/*_______________________________________________*/

DROP PROCEDURE IF EXISTS SELECT__LUGAR_FOTOS;
DELIMITER $$

CREATE PROCEDURE SELECT__LUGAR_FOTOS(IN ID INT(5)
)
BEGIN

  DECLARE ID_ INT(5) ;
  DECLARE ID_LUGAR_ INT(5) ;
  DECLARE IMAGEM LONGBLOB;
  
  SET @ID_LUGAR_ = ID;

  SELECT 
    FOTOS.IMAGEM_1  
  FROM 
    FOTOS
    
    
  WHERE FOTOS.FK_LUGAR=@ID_LUGAR_;
END$$
DELIMITER ;


/*

CALL SELECT__LUGAR_FOTOS(15);

SELECT * FROM USUARIO




SELECT * FROM LUGAR;
SELECT * FROM FOTOS;
*/



  
  
/*_______________________________________________*/
  
DROP PROCEDURE IF EXISTS SELECT__LUGAR_LUGAR;
DELIMITER $$

CREATE PROCEDURE SELECT__LUGAR_LUGAR(
IN ID INT(5)
)
BEGIN

  DECLARE ID_ INT(5) ;
  DECLARE ID_LUGAR_ INT(5) ;
  DECLARE imagem LONGBLOB;
  
  SET @ID_ = ID; 

  SELECT 
    LUGAR.ID_LUGAR,
    LUGAR.TITULO      ,
    LUGAR.DESCRICAO   ,
    LUGAR.CEP         ,
    LUGAR.ENDERECO    ,
    LUGAR.NUMERO      ,
    LUGAR.COMPLEMENTO ,
    LUGAR.BAIRRO      ,
    LUGAR.CIDADE      ,
    LUGAR.ESTADO      ,
    LUGAR.PONTO_REF  
  FROM 
    LUGAR 
    
    
  WHERE LUGAR.FK_USUARIO=@ID_;
END$$
DELIMITER ;

/*
CALL SELECT__LUGAR_LUGAR(1);

SELECT * FROM USUARIO




SELECT * FROM LUGAR;
SELECT * FROM FOTOS;
*/
  
  
  /*_______________________________________________*/
  
USE ROOM8;
DROP PROCEDURE IF EXISTS ATUALIZA_LUGAR;
DELIMITER $$


CREATE PROCEDURE ATUALIZA_LUGAR(
IN TITULO         VARCHAR(150),
IN DESCRICAO      VARCHAR(255),
IN CEP            VARCHAR(10) ,
IN ENDERECO       VARCHAR(255),
IN NUMERO         VARCHAR(20) ,
IN COMPLEMENTO    VARCHAR(60) ,
IN BAIRRO         VARCHAR(60) ,
IN CIDADE         VARCHAR(60) ,
IN ESTADO         CHAR(2),
IN PONTO_REF      VARCHAR(60) ,
IN 	ID_LUGAR     INT(5) 
)
BEGIN

  DECLARE TITULO_         VARCHAR(150) ;
  DECLARE DESCRICAO_      VARCHAR(255) ;
  DECLARE CEP_            VARCHAR(10)  ;
  DECLARE ENDERECO_       VARCHAR(255) ;
  DECLARE NUMERO_         VARCHAR(20)  ;
  DECLARE COMPLEMENTO_    VARCHAR(60)  ;
  DECLARE BAIRRO_         VARCHAR(60)  ;
  DECLARE CIDADE_         VARCHAR(60) ;
  DECLARE ESTADO_         CHAR(2);
  DECLARE PONTO_REF_      VARCHAR(60) ;
  DECLARE ID_LUGAR_      INT(5);
  
  SET @TITULO_    =TITULO      ;
  SET @DESCRICAO_ =DESCRICAO;
  SET @CEP_       =CEP;
  SET @ENDERECO_  =ENDERECO;
  SET @NUMERO_    =NUMERO;
  SET @COMPLEMENTO_=COMPLEMENTO;
  SET @BAIRRO_    =BAIRRO;
  SET @CIDADE_    =CIDADE;
  SET @ESTADO_   = ESTADO;
  SET @PONTO_REF_ = PONTO_REF;
  SET @ID_LUGAR_ = ID_LUGAR;
  
  UPDATE LUGAR 
  SET
  
TITULO     =@TITULO_    ,
DESCRICAO = @DESCRICAO_ ,
CEP        =@CEP_        , 
ENDERECO   =@ENDERECO_    ,
NUMERO     =@NUMERO_      ,
COMPLEMENTO=@COMPLEMENTO_,
BAIRRO     =@BAIRRO_      ,
CIDADE     =@CIDADE_      ,
ESTADO     =@ESTADO_      ,
PONTO_REF  =@PONTO_REF_   
  
  WHERE LUGAR.ID_LUGAR = @ID_LUGAR_;
  
  

     
END$$
DELIMITER ;

/*
CALL ATUALIZA_LUGAR(

'ATUALIZA',
'ATUALIZA',
'99',
'Rua STUALIZA ',
'2963',
'ATUALIZA 2',
'ATUALIZA 2',
'ATUALIZA 2',
'PR',
'ATUALIZA 2',
5);

SELECT * FROM LUGAR;
*/


  
  
  
  
  
  
  
  
  
  


























