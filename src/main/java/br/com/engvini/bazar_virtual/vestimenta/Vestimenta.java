package br.com.engvini.bazar_virtual.vestimenta;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "vestimentas")
@Entity(name = "vestimentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vestimenta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    private String nome;

    private double preco;

    private String image;

    private Categoria categoria;

    public Vestimenta(VestimentaDTO data){
        this.id = data.id();
        this.nome = data.nome();
        this.preco = data.preco();
        this.image = data.image();
        this.categoria = data.categoria();
    }




}
