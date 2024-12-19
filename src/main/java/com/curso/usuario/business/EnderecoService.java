package com.curso.usuario.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.usuario.infra.entity.EnderecoEntity;
import com.curso.usuario.infra.repository.EnderecoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoService {

	@Autowired
    private EnderecoRepository enderecoRepository;


    public EnderecoEntity salvaEndereco(EnderecoEntity enderecoEntity) {
        return enderecoRepository.save(enderecoEntity);
    }

    public EnderecoEntity findByUsuarioId(String usuarioId) {
        return enderecoRepository.findByUsuarioId(usuarioId);
    }

    public void deleteByUsuarioId(String usuarioId) {
        enderecoRepository.deleteByUsuarioId(usuarioId);
    }


}