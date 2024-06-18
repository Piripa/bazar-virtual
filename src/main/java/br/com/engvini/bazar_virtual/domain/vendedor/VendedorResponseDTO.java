package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record VendedorResponseDTO(String id, Long usuario, UUID vestimentas) {

}
