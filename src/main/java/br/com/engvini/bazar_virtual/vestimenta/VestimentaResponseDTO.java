package br.com.engvini.bazar_virtual.vestimenta;

import java.util.UUID;

public record VestimentaResponseDTO(UUID id, String nome, int preco, String image, Categoria categoria ){

    public VestimentaResponseDTO(Vestimenta vestimenta){
        this(vestimenta.getId(), vestimenta.getNome(), vestimenta.getPreco(), vestimenta.getImage(), vestimenta.getCategoria());
    }

}
