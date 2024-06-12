package br.com.engvini.bazar_virtual.domain.carrinhoCompras;

import br.com.engvini.bazar_virtual.domain.endereco.Endereco;
import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "buycars")
@Table(name = "buycars")

public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany
    private List<Vestimenta> vestimenta;

    @OneToOne
    private Usuario usuario;

    private Endereco endereco;
}
