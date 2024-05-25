package br.com.engvini.bazar_virtual.controller;


import br.com.engvini.bazar_virtual.vestimenta.Vestimenta;
import br.com.engvini.bazar_virtual.vestimenta.VestimentaDTO;
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
    private ResponseEntity createVestimenta(@RequestBody VestimentaDTO data){
        Vestimenta vestimenta = new Vestimenta(data);
        vestimentaRepository.save(vestimenta);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    private List<VestimentaDTO> getAllVestimentas(){
        List<VestimentaDTO> allVestimentas = vestimentaRepository.findAll().stream().map(VestimentaDTO::new).toList();
        return allVestimentas;
    }

}
