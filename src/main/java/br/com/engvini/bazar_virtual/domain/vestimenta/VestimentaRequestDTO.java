package br.com.engvini.bazar_virtual.domain.vestimenta;

import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;

public record VestimentaRequestDTO(String nome, int preco, String image, Long vendedor, Categoria categoria) {
}
