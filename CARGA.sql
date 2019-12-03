INSERT INTO TP_CADASTRO (
  ID_TP_CAD ,
  DESC_CAD 
)

VALUES(
  1,
  'ADM'
);


INSERT INTO USUARIO(
  ID_USUARIO  ,
  NOME        ,
  CPF         ,
  EMAIL        ,
  SENHA       ,
  TP_CADASTRO 
)
VALUES(
  NULL        ,
  'LUCAS'     ,
  '4545454' ,
  'LUCAS@LUCAS',
  '123'       ,
  1
);





INSERT INTO TELEFONE (
  ID_TEL    ,     
  FK_USUARIO,  
  TEL    
)
VALUES(
  NULL,
  2   ,
  '212'
  ); 
  
  
  
  
  
  
  insert into lugar(
  ID_LUGAR      ,
  TITULO        ,
  DESCRICAO     ,
  CEP           ,
  ENDERECO      ,
  NUMERO        ,
  COMPLEMENTO   ,
  BAIRRO        ,
  CIDADE        ,
  ESTADO        ,
  PONTO_REF     ,
  FK_USUARIO
  )
  
  values(
  null,
  'Teste insert2',
  'Insert2',
  '2245693',
  'Rua 2 ',
  '2963',
  'Casa 2',
  'Centro 2',
  'CWB 2',
  'SP',
  'Mercado 2',
  2
  
  );
  
insert into fOTOS (
ID_IMAGEM ,
IMAGEM_1 ,
FK_LUGAR 
)
values(
null,
1,
15
)
;
  