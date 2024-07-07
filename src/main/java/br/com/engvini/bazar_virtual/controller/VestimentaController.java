package br.com.engvini.bazar_virtual.controller;


import br.com.engvini.bazar_virtual.domain.vestimenta.*;
import br.com.engvini.bazar_virtual.service.VestimentaService;
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
    private VestimentaService vestimentaService;

    @PostMapping
    public ResponseEntity createVestimenta(@RequestBody VestimentaRequestDTO data){
        Vestimenta vestimenta = vestimentaService.createdVestimenta(data);
        return ResponseEntity.ok(data);
    }
    @GetMapping
    public List<VestimentaResponseDTO> getAllVestimentas(){
        List<VestimentaResponseDTO> allVestimentas = vestimentaService.getAllVestimentas();
        return allVestimentas;
    }
    @GetMapping("/{id}")
    public VestimentaResponseDTO getVestimentaById(@PathVariable  UUID id) {
        VestimentaResponseDTO vestimentaResponseDTO = vestimentaService.getVestimentaById(id);
        return vestimentaResponseDTO;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteVestimenta(@PathVariable  UUID id){
       return vestimentaService.deleteVestimenta(id);
    }
    @PutMapping
    public ResponseEntity updateVestimenta(@RequestBody AtualizarVestimenta data){
        VestimentaResponseDTO attVestimenta = vestimentaService.updateVestimenta(data);
        return ResponseEntity.ok((attVestimenta));
    }

}
