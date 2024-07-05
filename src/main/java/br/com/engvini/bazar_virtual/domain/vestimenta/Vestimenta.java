package br.com.engvini.bazar_virtual.domain.vestimenta;


import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedores_id")
    @JsonBackReference
    private Vendedor vendedores;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Vestimenta(VestimentaRequestDTO data){
        this.nome = data.nome();
        this.preco = data.preco();
        this.image = data.image();
        this.categoria = data.categoria();
        this.vendedores = data.vendedor();
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
