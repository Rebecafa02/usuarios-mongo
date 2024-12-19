package com.curso.usuario.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.curso.usuario.api.response.UsuarioResponseDTO;
import com.curso.usuario.infra.entity.EnderecoEntity;
import com.curso.usuario.infra.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper{

	@Mapping(target = "id", source = "usuario.id")
	@Mapping(target = "nome", source = "usuario.nome")
	@Mapping(target = "documento", source = "usuario.documento")
	@Mapping(target = "endereco", source = "enderecoEntity")
	UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuario, EnderecoEntity enderecoEntity);
	
}
