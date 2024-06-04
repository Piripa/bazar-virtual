package br.com.engvini.bazar_virtual.controller;


import br.com.engvini.bazar_virtual.domain.vestimenta.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vestimenta")
public class VestimentaController {

    @Autowired
    private VestimentaRepository vestimentaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createVestimenta(@RequestBody VestimentaRequestDTO data){
        Vestimenta vestimenta = new Vestimenta(data);
        vestimentaRepository.save(vestimenta);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<VestimentaResponseDTO> getAllVestimentas(){
        List<VestimentaResponseDTO> allVestimentas = vestimentaRepository.findAll().stream().map(VestimentaResponseDTO::new).toList();
        return allVestimentas;
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteVestimenta(@PathVariable  UUID id){
        Vestimenta vestimentaExcluir = vestimentaRepository.getReferenceById(id);
        vestimentaRepository.delete(vestimentaExcluir);
        return ResponseEntity.ok("Deletado com sucesso: " + vestimentaExcluir.getNome());
    }
    @PutMapping
    @Transactional
    public ResponseEntity updateVestimenta(@RequestBody AtualizarVestimenta data){
        Vestimenta attVestimenta = vestimentaRepository.getReferenceById(data.id());
        attVestimenta.AtualizaVestimenta(data);
        vestimentaRepository.save(attVestimenta);
        return ResponseEntity.ok(new VestimentaResponseDTO(attVestimenta));
    }

}
