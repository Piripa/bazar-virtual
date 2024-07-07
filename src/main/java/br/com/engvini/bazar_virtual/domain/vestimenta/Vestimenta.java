package br.com.engvini.bazar_virtual.domain.vestimenta;


import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "vestimentas")
@Entity(name = "vestimentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vestimenta {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private int preco;

    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendedores_id")
    @JsonBackReference
    private Vendedor vendedores;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Vestimenta(String nome, int preco, String image, Vendedor vendedores, Categoria categoria){
        this.nome = nome;
        this.preco = preco;
        this.image = image;
        this.categoria = categoria;
        this.vendedores = vendedores;
    }
    public void AtualizaVestimenta(AtualizarVestimenta data){
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if(data.preco() != 0){
            this.preco = data.preco();
        }
        if(data.image() != null){
            this.image = data.image();
        }
        if(data.categoria() != null){
            this.categoria = data.categoria();
        }
    }




}
