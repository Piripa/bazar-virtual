package br.com.engvini.bazar_virtual.service;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.usuario.UsuarioRepository;
import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorRepository;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorRequestDTO;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorResponseDTO;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import br.com.engvini.bazar_virtual.domain.vestimenta.VestimentaRepository;
import br.com.engvini.bazar_virtual.domain.vestimenta.VestimentaRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VestimentaRepository vestimentaRepository;

    public VendedorService(VendedorRepository vendedorRepository, UsuarioRepository usuarioRepository, VestimentaRepository vestimentaRepository) {
        this.vendedorRepository = vendedorRepository;
        this.usuarioRepository = usuarioRepository;
        this.vestimentaRepository = vestimentaRepository;
    }

    @Transactional
    public Vendedor createVendedor(@RequestBody VendedorRequestDTO vendedorRequestDTO){
        if(!usuarioRepository.existsById(vendedorRequestDTO.usuario_id())){
            throw new RuntimeException("Usuário não encontrado");
        }
        if(!(vestimentaRepository.existsById(vendedorRequestDTO.vestimentas()))){
            throw new RuntimeException("Vestimenta não encontrada");
        }

        Usuario user = usuarioRepository.getReferenceById(vendedorRequestDTO.usuario_id());
        List<Vestimenta> vestimentaArrayList = vendedorRepository.getListVestimentaByIdVendedor(vendedorRequestDTO.usuario_id()).getVestimenta();
        Vendedor vendedor = new Vendedor(user,vestimentaArrayList);
        vendedorRepository.save(vendedor);
        return vendedor;



    }

//    public VendedorResponseDTO getVendedorById(String id){
//        Vendedor vendedor = vendedorRepository.getReferenceById(id);
//        return new VendedorResponseDTO();
//    }
//
//    public List<VendedorResponseDTO> getListVendedor(){
//        List<VendedorResponseDTO> vendedor = vendedorRepository.findAll().stream().map(VendedorResponseDTO::new).toList();
//        return vendedor;
//    }
//
//    public void UpdateVendedor(@RequestBody VendedorRequestDTO vendedorRequestDTO){
//
//    }
//    public void deleteVendedor(String id){
//        Vendedor vendedor = vendedorRepository.getReferenceById(id);
//        vendedorRepository.delete(vendedor);
//    }
}
