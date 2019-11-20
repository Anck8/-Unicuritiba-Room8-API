/*
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: Procedure criada para realizar o delete do Usuario.                       ::
:: Todas as informaçãoes relacionadas ao Usuario serão deletadas do Banco    ::
:: call deletar_usuario(9856412)                                             ::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
*/

drop procedure deletar_usuario

DELIMITER $$
CREATE PROCEDURE DELETAR_USUARIO(IN CPF VARCHAR(15))
BEGIN
DECLARE
  CPF VARCHAR(15) DEFAULT CPF;
  
SET 
  FOREIGN_KEY_CHECKS = 0;
DELETE 
  USUARIO.*  ,
  TELEFONE.* ,
  lugar.*    ,
  fotos.*    
  
FROM
  USUARIO, TELEFONE, lugar, fotos
WHERE
  USUARIO.CPF = CPF
AND 
  TELEFONE.FK_USUARIO = USUARIO.ID_USUARIO
AND
  lugar.fk_usuario = usuario.id_usuario
AND
  fotos.fk_lugar = lugar.id_lugar;
SET 
  FOREIGN_KEY_CHECKS = 1;

END$$
DELIMITER ;


