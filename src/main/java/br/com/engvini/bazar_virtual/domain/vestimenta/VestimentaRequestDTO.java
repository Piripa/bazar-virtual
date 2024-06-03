package br.com.engvini.bazar_virtual.domain.vestimenta;

public record VestimentaRequestDTO(String nome, int preco, String image, Categoria categoria) {
}
