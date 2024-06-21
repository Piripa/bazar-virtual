package br.com.engvini.bazar_virtual.domain.vestimenta;

import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;

import java.util.UUID;

public record AtualizarVestimenta(UUID id, String nome, int preco, String image, Vendedor vendedor, Categoria categoria) {
}
