package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "vendedores")
@Table(name = "vendedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Vendedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuariov_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "vendedores",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Vestimenta> vestimenta;

    public Vendedor(Usuario usuario, Vestimenta vestimenta) {
        this.usuario = usuario;
        if (this.vestimenta == null) {
            this.vestimenta = new ArrayList<>();
            this.vestimenta.add(vestimenta);
        } else {
            this.vestimenta.add(vestimenta);
        }
    }

}
