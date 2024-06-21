package br.com.engvini.bazar_virtual.domain.vendedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {


}
