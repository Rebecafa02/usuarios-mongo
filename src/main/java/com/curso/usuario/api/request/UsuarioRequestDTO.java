package com.curso.usuario.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UsuarioRequestDTO {

	private String nome;
	
	@JsonProperty(required = true)
	private String email;
	
	private String documento;
	private EnderecoRequestDTO endereco;
}
