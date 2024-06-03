package br.com.engvini.bazar_virtual.controller;

import br.com.engvini.bazar_virtual.usuario.Usuario;
import br.com.engvini.bazar_virtual.usuario.UsuarioRepository;
import br.com.engvini.bazar_virtual.usuario.UsuarioRequestDTO;
import br.com.engvini.bazar_virtual.usuario.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
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
}

