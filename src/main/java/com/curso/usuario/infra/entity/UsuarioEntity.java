package com.curso.usuario.infra.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "usuario.entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

	@Id
	private String id;
	private String nome;
	private String email;
	private String documento;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
}
