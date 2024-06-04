package br.com.engvini.bazar_virtual.domain.vestimenta;

import java.util.UUID;

public record AtualizarVestimenta(UUID id, String nome, int preco, String image, Categoria categoria) {
}
