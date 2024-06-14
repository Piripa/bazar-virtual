package br.com.engvini.bazar_virtual.domain.carrinhoCompras;

import br.com.engvini.bazar_virtual.domain.endereco.Endereco;
import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "buycars")
@Table(name = "buycars")

public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vestimenta_id")
    private List<Vestimenta> vestimenta;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate datetime;
}
