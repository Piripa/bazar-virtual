package br.com.engvini.bazar_virtual.service;

import br.com.engvini.bazar_virtual.domain.vestimenta.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VestimentaService {

    @Autowired
    private VestimentaRepository vestimentaRepository;

    public VestimentaService(VestimentaRepository vestimentaRepository) {
        this.vestimentaRepository = vestimentaRepository;
    }
    @Transactional
    public Vestimenta createdVestimenta(VestimentaRequestDTO vestimentaRequestDTO) {
        Vestimenta vestimenta = new Vestimenta(vestimentaRequestDTO);
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
    public VestimentaResponseDTO updateVestimenta( AtualizarVestimenta vestimentaRequestDTO) {
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(vestimentaRequestDTO.id());
        if(vestimenta != null) {
            vestimenta.AtualizaVestimenta(vestimentaRequestDTO);
            vestimentaRepository.save(vestimenta);
        }
        return new VestimentaResponseDTO(vestimenta);
    }
    @Transactional
    public void deleteVestimenta(UUID id) {
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(id);
        vestimentaRepository.delete(vestimenta);
    }


}
