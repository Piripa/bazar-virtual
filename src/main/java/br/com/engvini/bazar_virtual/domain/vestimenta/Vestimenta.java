package br.com.engvini.bazar_virtual.domain.vestimenta;


import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedores;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Vestimenta(VestimentaRequestDTO data){
        this.nome = data.nome();
        this.preco = data.preco();
        this.image = data.image();
        this.categoria = data.categoria();
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
