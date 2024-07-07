package br.com.engvini.bazar_virtual.domain.carrinhoCompras;

import java.util.Date;
import java.util.UUID;

public record ComprasRequestDTO(Long usuario_id, UUID vestimenta_id) {
}
