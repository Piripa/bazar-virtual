package br.com.engvini.bazar_virtual.controller;

import br.com.engvini.bazar_virtual.domain.usuario.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity salvarUser(@RequestBody UsuarioRequestDTO usuario) {
        Usuario usuarioSalvo = new Usuario(usuario);
        usuarioRepository.save(usuarioSalvo);
        return ResponseEntity.ok("Usuário Salvo com sucesso");
    }

    @GetMapping
    public List<UsuarioResponseDTO>listUsers() {
        List<UsuarioResponseDTO> usuarioResponseDTO = usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return usuarioResponseDTO;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuario);
        return ResponseEntity.ok("Deletado " + usuario.getNome());
    }
    @PutMapping()
    @Transactional
    public ResponseEntity updateUser(@RequestBody AtualizarUsuario usuario) {
        Usuario user = usuarioRepository.getReferenceById(usuario.id());
        if(user != null) {
            user.atualizarInfo(usuario);
            usuarioRepository.save(user);
        }
        return ResponseEntity.ok(new UsuarioResponseDTO(user));
    }

}

