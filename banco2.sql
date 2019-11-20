select * from usuario;
select * from telefone;
select * from lugar;
select * from fotos;

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
  'jean'     ,
  '4577545' ,
  'jean@jean',
  '123'       ,
  1
);



INSERT INTO TP_CADASTRO (
  ID_TP_CAD ,
  DESC_CAD 
)

VALUES(
  1,
  'ADM'
);



INSERT INTO TELEFONE (
  ID_TEL    ,     
  FK_USUARIO,  
  TEL    
)
VALUES(
  NULL,
  2   ,
  '56451231'
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
2
)
;
  
  

select  
       usuario.nome,
       usuario.cpf,
       usuario.email,
       usuario.senha,
       telefone.tel,
       tp_cadastro.desc_cad
       from usuario 
       inner join telefone 
       inner join tp_cadastro 
       on tp_cadastro.ID_TP_CAD = usuario.tp_cadastro 
       and usuario.id_usuario = telefone.fk_usuario
       where usuario.cpf = 9856412
       ;
       
       



start transaction;
SET 
  foreign_key_checks = 0;
DELETE 
  usuario.*,
  telefone.*
FROM
  usuario, telefone
WHERE
  usuario.cpf = 454512154
AND 
  telefone.fk_usuario = usuario.id_usuario;
SET 
  foreign_key_checks = 1;
commit ;
            
select * from usuario;



DELIMITER $$

create procedure deletar_usuario
@cpf varchar(15)
as begin
SET 
  foreign_key_checks = 0;
DELETE 
  usuario.*,
  telefone.*
FROM
  usuario, telefone
WHERE
  usuario.cpf = 454512154
AND 
  telefone.fk_usuario = usuario.id_usuario;
SET 
  foreign_key_checks = 1;

end$$
DELIMITER ;

   