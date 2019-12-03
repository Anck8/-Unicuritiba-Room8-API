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
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  