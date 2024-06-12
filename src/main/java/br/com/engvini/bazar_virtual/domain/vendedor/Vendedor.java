package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "vendedores")
@Table(name = "vendedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Vendedor {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private Usuario usuario;

    @OneToMany
    private List<Vestimenta> vestimenta;
}
