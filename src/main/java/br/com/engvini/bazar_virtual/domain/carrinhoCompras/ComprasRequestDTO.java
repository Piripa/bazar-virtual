package br.com.engvini.bazar_virtual.domain.carrinhoCompras;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record ComprasRequestDTO(@NotNull Long usuario_id, @NotNull UUID vestimenta_id) {
}
