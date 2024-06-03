package br.com.engvini.bazar_virtual.domain.usuario;

import br.com.engvini.bazar_virtual.domain.endereco.Endereco;

public record UsuarioRequestDTO(String nome, String email, String senha, String telefone, Endereco endereco) {
}
