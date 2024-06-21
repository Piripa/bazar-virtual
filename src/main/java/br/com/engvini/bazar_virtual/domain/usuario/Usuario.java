package br.com.engvini.bazar_virtual.domain.usuario;


import br.com.engvini.bazar_virtual.domain.endereco.Endereco;
import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
        this.senha = data.senha();
        this.telefone = data.telefone();
        this.endereco = new Endereco(data.endereco());
    }


    public void atualizarInfo(AtualizarUsuario usuario) {
        if(usuario.nome() != null){
            this.setNome(usuario.nome());
        }
        if(usuario.email() != null){
            this.setEmail(usuario.email());
        }
        if(usuario.senha() != null){
            this.setSenha(usuario.senha());
        }
        if(usuario.telefone() != null){
            this.setTelefone(usuario.telefone());
        }
        if(usuario.endereco() != null){
            this.endereco.AtualizarEnd(usuario.endereco());
        }
    }
}
