package br.com.engvini.bazar_virtual.domain.carrinhoCompras;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;

import java.time.LocalDateTime;
import java.util.List;

public record ComprasResponseDTO(String id, List<Vestimenta> vestimentaList, Usuario usuario, LocalDateTime localDateTime) {
}
