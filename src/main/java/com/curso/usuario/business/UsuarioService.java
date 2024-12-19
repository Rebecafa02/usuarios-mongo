package com.curso.usuario.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.curso.usuario.api.converter.UsuarioConverter;
import com.curso.usuario.api.converter.UsuarioMapper;
import com.curso.usuario.api.request.UsuarioRequestDTO;
import com.curso.usuario.api.response.UsuarioResponseDTO;
import com.curso.usuario.infra.entity.EnderecoEntity;
import com.curso.usuario.infra.entity.UsuarioEntity;
import com.curso.usuario.infra.exceptions.BusinessException;
import com.curso.usuario.infra.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioConverter usuarioConverter;
	@Autowired
	private UsuarioMapper usuarioMapper;
	@Autowired
	private EnderecoService enderecoService;

    public UsuarioService(EnderecoService enderecoService, UsuarioConverter usuarioConverter, UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.enderecoService = enderecoService;
        this.usuarioConverter = usuarioConverter;
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }
	
	
	public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity) {
		return usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
		try {
			Assert.notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
			UsuarioEntity usuarioEntity = salvaUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            EnderecoEntity enderecoEntity = enderecoService.salvaEndereco(
                    usuarioConverter.paraEnderecoEntity(usuarioRequestDTO.getEndereco(), usuarioEntity.getId()));
            return usuarioMapper.paraUsuarioResponseDTO(usuarioEntity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);

		}
	
	}
	
	 public UsuarioResponseDTO buscaDadosUsuario(String email) {
	        try {
	            UsuarioEntity entity = usuarioRepository.findByEmail(email);
	            Assert.notNull(entity, "Usuário não encontrado");
	            EnderecoEntity enderecoEntity = enderecoService.findByUsuarioId(entity.getId());

	            return usuarioMapper.paraUsuarioResponseDTO(entity, enderecoEntity);
	        } catch (Exception e) {
	            throw new BusinessException("Erro ao buscar dados de usuário", e);
	        }
	    }

	    @Transactional
	    public void deletaDadosUsuario(String email) {
	        UsuarioEntity entity = usuarioRepository.findByEmail(email);
	        usuarioRepository.deleteByEmail(email);
	        enderecoService.deleteByUsuarioId(entity.getId());

	    }

}


