package br.com.engvini.bazar_virtual.vestimenta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VestimentaRepository extends JpaRepository<Vestimenta, UUID> {
}
