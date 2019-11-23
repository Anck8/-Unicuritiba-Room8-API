
drop procedure if exists deletar_usuario;

DELIMITER $$

CREATE PROCEDURE DELETAR_USUARIO(IN CPF VARCHAR(15))

BEGIN
DECLARE CPF_ VARCHAR(15) ;
DECLARE ID VARCHAR(15) DEFAULT NULL;
DECLARE ID_FOTO VARCHAR(15) DEFAULT NULL;

IF  EXISTS (
    
    SELECT * FROM USUARIO WHERE USUARIO.CPF = CPF
  
  )
THEN
  
  SET @ID      = (SELECT ID_USUARIO FROM USUARIO WHERE USUARIO.CPF=CPF);
  SET @ID_FOTO = (SELECT ID_LUGAR FROM  LUGAR WHERE LUGAR.FK_USUARIO =@ID);  
  DELETE FROM USUARIO  WHERE ID_USUARIO = @ID;
  DELETE FROM TELEFONE WHERE FK_USUARIO = @ID; 
  
END IF; 
 
  
IF EXISTS (
 
  SELECT ID_LUGAR FROM  LUGAR WHERE FK_USUARIO = @ID
  
  )
THEN
  
  DELETE FROM FOTOS WHERE  FOTOS.FK_LUGAR = @ID_FOTO;
  DELETE FROM LUGAR WHERE FK_USUARIO      = @ID;
  
END IF; 


END$$
DELIMITER ;

/*
call deletar_usuario(12312)

select * from usuario
select * from telefone
select * from fotos
select * from lugar
*/







delete from fotos where fotos.fk_lugar = 

select * from usuario
select * from telefone
select * from fotos
select * from lugar


delete from telefone
delete from lugar
delete from fotos





call deletar_usuario(12312)
select * from tp_cadastro



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
       where usuario.cpf = 32432423
       ;

