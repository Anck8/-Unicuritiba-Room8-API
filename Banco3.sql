DELIMITER $$

create procedure deletar_usuario(in cpf varchar(15))

begin
declare cpf varchar(15) DEFAULT cpf

;

SET 
  foreign_key_checks = 0;
DELETE 
  usuario.*  ,
  telefone.* ,
  lugar.*    ,
  fotos.*    
FROM
  usuario, telefone,lugar,fotos
WHERE
  usuario.cpf = cpf
AND 
  telefone.fk_usuario = usuario.id_usuario
AND
  lugar.fk_usuario = usuario.id_usuario
AND
  fotos.fk_lugar = lugar.id_lugar
  ;
SET 
  foreign_key_checks = 1;

end$$
DELIMITER ;




call deletar_usuario(9856412)

select * from usuario
select * from telefone



