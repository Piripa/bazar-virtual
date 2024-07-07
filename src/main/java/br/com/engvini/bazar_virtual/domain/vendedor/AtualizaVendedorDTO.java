package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.AtualizarUsuario;
import br.com.engvini.bazar_virtual.domain.usuario.Usuario;

public record AtualizaVendedorDTO(Long id, AtualizarUsuario user) {

}
