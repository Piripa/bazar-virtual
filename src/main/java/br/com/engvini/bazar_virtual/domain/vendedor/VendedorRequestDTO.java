package br.com.engvini.bazar_virtual.domain.vendedor;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;


public record VendedorRequestDTO(@NotNull Long usuario_id, @NotNull UUID vestimentas) {
}
