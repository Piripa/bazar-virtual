package br.com.engvini.bazar_virtual.domain.endereco;

public record EnderecoDTO( String logradouro, String numero, String complemento, String bairro, String cidade, String uf, String cep) {

    public EnderecoDTO(Endereco endereco){
        this(endereco.getLogradouro(), endereco.getNumero(), endereco.getCep(), endereco.getBairro(), endereco.getCidade(), endereco.getUf(), endereco.getCep());
    }

}
