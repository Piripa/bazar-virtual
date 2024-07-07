package br.com.engvini.bazar_virtual.service;

import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorRepository;
import br.com.engvini.bazar_virtual.domain.vestimenta.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VestimentaService {

    @Autowired
    private VestimentaRepository vestimentaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public VestimentaService(VestimentaRepository vestimentaRepository) {
        this.vestimentaRepository = vestimentaRepository;
    }
    @Transactional
    public Vestimenta createdVestimenta(VestimentaRequestDTO vestimentaRequestDTO) {
        Vendedor getVendedor = vendedorRepository.getReferenceById(vestimentaRequestDTO.vendedor());
        Vestimenta vestimenta = new Vestimenta(vestimentaRequestDTO.nome(),
                                                vestimentaRequestDTO.preco(),
                                                vestimentaRequestDTO.image(),
                                                getVendedor,
                                                vestimentaRequestDTO.categoria());
        vestimentaRepository.save(vestimenta);
        return vestimenta;
    }
    @Transactional
    public VestimentaResponseDTO getVestimentaById(UUID id) {
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(id);
        return new VestimentaResponseDTO(vestimenta);

    }
    @Transactional
    public List<VestimentaResponseDTO> getAllVestimentas() {
        List<VestimentaResponseDTO> listVestimentas = vestimentaRepository.findAll().stream().map(VestimentaResponseDTO::new).toList();
        return listVestimentas;
    }
    @Transactional
    public VestimentaResponseDTO updateVestimenta( AtualizarVestimenta atualizarVestimentaDTO) {
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(atualizarVestimentaDTO.id());
        if(vestimenta != null) {
            vestimenta.AtualizaVestimenta(atualizarVestimentaDTO);
            vestimentaRepository.save(vestimenta);
        }
        return new VestimentaResponseDTO(vestimenta);
    }
    @Transactional
    public ResponseEntity deleteVestimenta(UUID id) {
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(id);
        vestimentaRepository.delete(vestimenta);
        return ResponseEntity.ok().build();
    }


}
