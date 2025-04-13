package br.com.engvini.bazar_virtual.controller;


import br.com.engvini.bazar_virtual.domain.carrinhoCompras.CarrinhoCompras;
import br.com.engvini.bazar_virtual.domain.carrinhoCompras.ComprasRequestDTO;
import br.com.engvini.bazar_virtual.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shopping")
@RestController
public class ComprasController {

    @Autowired
    private ComprasService comprasService;


    @PostMapping
    public ResponseEntity createCompras(@RequestBody ComprasRequestDTO comprasRequestDTO){
        CarrinhoCompras carrinhoCompras = comprasService.createCarrinhoCompras(comprasRequestDTO);
        return ResponseEntity.ok().body(carrinhoCompras);
    }

}
