package br.com.engvini.bazar_virtual.controller;


import br.com.engvini.bazar_virtual.vestimenta.Vestimenta;
import br.com.engvini.bazar_virtual.vestimenta.VestimentaRequestDTO;
import br.com.engvini.bazar_virtual.vestimenta.VestimentaResponseDTO;
import br.com.engvini.bazar_virtual.vestimenta.VestimentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vestimenta")
public class VestimentaController {

    @Autowired
    private VestimentaRepository vestimentaRepository;

    @PostMapping
    private ResponseEntity createVestimenta(@RequestBody VestimentaRequestDTO data){
        Vestimenta vestimenta = new Vestimenta(data);
        vestimentaRepository.save(vestimenta);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    private List<VestimentaResponseDTO> getAllVestimentas(){
        List<VestimentaResponseDTO> allVestimentas = vestimentaRepository.findAll().stream().map(VestimentaResponseDTO::new).toList();
        return allVestimentas;
    }

}
