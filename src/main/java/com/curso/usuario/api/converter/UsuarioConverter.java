package com.curso.usuario.api.converter;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.curso.usuario.api.request.EnderecoRequestDTO;
import com.curso.usuario.api.request.UsuarioRequestDTO;
import com.curso.usuario.infra.entity.EnderecoEntity;
import com.curso.usuario.infra.entity.UsuarioEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {

	public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioDTO) {
		return UsuarioEntity.builder()
				.id(UUID.randomUUID().toString())
				.nome(usuarioDTO.getNome())
				.documento(usuarioDTO.getDocumento())
				.email(usuarioDTO.getEmail())
				.dataCadastro(LocalDateTime.now())
				.build();
	}
	
	public EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoDTO, String usuarioId) {
		return EnderecoEntity.builder()
				.rua(enderecoDTO.getRua())
				.bairro(enderecoDTO.getBairro())
				.usuarioId(usuarioId)
				.cep(enderecoDTO.getCep())
				.cidade(enderecoDTO.getCidade())
				.numero(enderecoDTO.getNumero())
				.complemento(enderecoDTO.getComplemento())
				.build();
	}
	
}
