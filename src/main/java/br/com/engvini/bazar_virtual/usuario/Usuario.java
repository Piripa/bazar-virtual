package br.com.engvini.bazar_virtual.usuario;


import br.com.engvini.bazar_virtual.endereco.Endereco;
import br.com.engvini.bazar_virtual.endereco.EnderecoDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    @Embedded
    private Endereco endereco;

    public Usuario(UsuarioRequestDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.endereco = new Endereco(data.endereco());
    }

}
