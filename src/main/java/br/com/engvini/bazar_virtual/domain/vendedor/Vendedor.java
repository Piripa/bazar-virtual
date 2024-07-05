package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "vendedores",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vestimenta> vestimenta = new ArrayList<>();

    public Vendedor(Usuario usuario, Vestimenta vestimenta) {
        this.usuario = usuario;
        this.AddVestimenta(vestimenta);

    }
    public void AddVestimenta(Vestimenta vestimenta) {
        this.vestimenta.add(vestimenta);
        vestimenta.setVendedores(this);
    }

}
