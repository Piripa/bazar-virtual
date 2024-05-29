package br.com.engvini.bazar_virtual.usuario;

import br.com.engvini.bazar_virtual.endereco.Endereco;

public record UsuarioResponseDTO(Long id, String nome, String email, String senha, String telefone, Endereco endereco) {

    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEndereco());
    }
}
