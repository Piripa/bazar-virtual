package br.com.engvini.bazar_virtual.controller;

import br.com.engvini.bazar_virtual.domain.usuario.UsuarioRequestDTO;
import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorRequestDTO;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorResponseDTO;
import br.com.engvini.bazar_virtual.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity createVendedor(@RequestBody VendedorRequestDTO vendedorRequestDTO){
        Vendedor vendedor = vendedorService.createVendedor(vendedorRequestDTO);
        return  ResponseEntity.ok(vendedor);
    }

//    @GetMapping
//    public List<VendedorResponseDTO> readVendedor(){
//        List<VendedorResponseDTO> vendedorList = vendedorService.getListVendedor();
//        return vendedorList;
//    }

}
