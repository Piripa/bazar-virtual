package br.com.engvini.bazar_virtual.domain.carrinhoCompras;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "shopping")
@Table(name = "shopping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "vestimenta_id")
    private List<Vestimenta> vestimenta = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDateTime datetime;

    public CarrinhoCompras(Vestimenta vestimenta, Usuario usuario, LocalDateTime datetime) {
        this.usuario = usuario;
        this.datetime = datetime;
        this.vestimenta.add(vestimenta);


    }
}
