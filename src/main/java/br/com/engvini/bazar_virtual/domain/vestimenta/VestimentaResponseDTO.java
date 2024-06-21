package br.com.engvini.bazar_virtual.domain.vestimenta;

import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;

import java.util.UUID;

public record VestimentaResponseDTO(UUID id, String nome, int preco, String image, Vendedor vendedor, Categoria categoria ){

    public VestimentaResponseDTO(Vestimenta vestimenta){
        this(vestimenta.getId(), vestimenta.getNome(), vestimenta.getPreco(),vestimenta.getImage(),vestimenta.getVendedores() ,vestimenta.getCategoria());
    }

}
