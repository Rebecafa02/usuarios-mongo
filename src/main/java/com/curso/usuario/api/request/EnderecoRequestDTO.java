package com.curso.usuario.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class EnderecoRequestDTO {

	private String rua;
	
	private Long numero;
	
	private String bairro;
	
	private String complemento;
	
	private String cidade;
	
	private String cep;
}
