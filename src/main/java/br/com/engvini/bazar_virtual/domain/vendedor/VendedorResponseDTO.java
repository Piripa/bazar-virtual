package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;

import java.util.List;


public record VendedorResponseDTO(Long id, Usuario usuario, List<Vestimenta> vestimentas) {

    public VendedorResponseDTO(Vendedor vendedor) {
        this(vendedor.getId(), vendedor.getUsuario(), vendedor.getVestimenta());
    }

}
