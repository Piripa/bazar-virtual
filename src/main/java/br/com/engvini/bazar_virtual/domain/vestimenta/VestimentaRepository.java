package br.com.engvini.bazar_virtual.domain.vestimenta;

import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface VestimentaRepository extends JpaRepository<Vestimenta, UUID> {

}
