package br.com.engvini.bazar_virtual.domain.usuario;

import br.com.engvini.bazar_virtual.domain.endereco.Endereco;
import br.com.engvini.bazar_virtual.domain.endereco.EnderecoDTO;

public record AtualizarUsuario(Long id, String nome, String email, String senha, String telefone, EnderecoDTO endereco) {
}
