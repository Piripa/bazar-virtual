package br.com.engvini.bazar_virtual.vestimenta;


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

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Vestimenta(VestimentaRequestDTO data){
        this.nome = data.nome();
        this.preco = data.preco();
        this.image = data.image();
        this.categoria = data.categoria();
    }




}
