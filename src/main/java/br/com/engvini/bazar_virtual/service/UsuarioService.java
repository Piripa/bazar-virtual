package br.com.engvini.bazar_virtual.service;

import br.com.engvini.bazar_virtual.domain.usuario.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioService (UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario createUser(UsuarioRequestDTO usuario) {
        Usuario user = new Usuario(usuario);
        usuarioRepository.save(user);
        return user;
    }
    @Transactional
    public List<UsuarioResponseDTO> readUsers(){
        List<UsuarioResponseDTO> usuarios = usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return usuarios;
    }
    @Transactional
    public UsuarioResponseDTO readUserById(Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return new UsuarioResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO updateUser(AtualizarUsuario usuario) {
        Usuario user = usuarioRepository.getReferenceById(usuario.id());
        if(user != null) {
            user.atualizarInfo(usuario);
            usuarioRepository.save(user);
        }
        return new UsuarioResponseDTO(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        Usuario user = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(user);
    }
}
