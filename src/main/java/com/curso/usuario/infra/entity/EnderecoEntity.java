package com.curso.usuario.infra.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "endereco_entity")
public class EnderecoEntity {

	@Id
	private String id;
	private String usuarioId;
	private String rua;
	private Long numero;
	private String bairro;
	private String complemento;
	private String cidade;
	private String cep;
	
}
