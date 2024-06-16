package br.com.engvini.bazar_virtual.controller;

import br.com.engvini.bazar_virtual.domain.usuario.*;
import br.com.engvini.bazar_virtual.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity createUser(@RequestBody UsuarioRequestDTO usuario, UriComponentsBuilder ucBuilder) {
        Usuario user = usuarioService.createUser(usuario);
        URI uri = ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    public List<UsuarioResponseDTO>listUsers() {
        List<UsuarioResponseDTO> usuarioResponseDTO = usuarioService.readUsers();
        return usuarioResponseDTO;
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO readUserById(@PathVariable Long id) {
        UsuarioResponseDTO usuarioById = usuarioService.readUserById(id);
        return usuarioById;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        usuarioService.deleteUser(id);
        return ResponseEntity.ok("Deleted user ");
    }
    @PutMapping()
    public ResponseEntity updateUser(@RequestBody AtualizarUsuario usuario) {
        UsuarioResponseDTO user = usuarioService.updateUser(usuario);
        return ResponseEntity.ok((user));
    }

}

