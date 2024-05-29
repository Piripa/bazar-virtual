package br.com.engvini.bazar_virtual.usuario;

import br.com.engvini.bazar_virtual.endereco.Endereco;

public record UsuarioRequestDTO(String nome, String email, String senha, String telefone, Endereco endereco) {
}
