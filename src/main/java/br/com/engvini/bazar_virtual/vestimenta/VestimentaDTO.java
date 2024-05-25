package br.com.engvini.bazar_virtual.vestimenta;

public record VestimentaDTO(Long id, String nome, double preco, String image, Categoria categoria ){

    public VestimentaDTO(Vestimenta vestimenta){
        this(vestimenta.getId(), vestimenta.getNome(), vestimenta.getPreco(), vestimenta.getImage(), vestimenta.getCategoria());
    }

}
