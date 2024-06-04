package br.com.engvini.bazar_virtual.domain.endereco;


import br.com.engvini.bazar_virtual.domain.usuario.UsuarioResponseDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Endereco {

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    public Endereco(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.uf = endereco.getUf();
        this.cep = endereco.getCep();
    }

    public void AtualizarEnd(EnderecoDTO dados) {
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.numero() != null){
            this.numero = dados.numero();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null){
            this.uf = dados.uf();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }

    }
}

