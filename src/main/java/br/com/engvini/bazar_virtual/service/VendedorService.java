package br.com.engvini.bazar_virtual.service;

import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.usuario.UsuarioRepository;
import br.com.engvini.bazar_virtual.domain.vendedor.*;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import br.com.engvini.bazar_virtual.domain.vestimenta.VestimentaRepository;
import br.com.engvini.bazar_virtual.domain.vestimenta.VestimentaRequestDTO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
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

    @Autowired
    private UsuarioService usuarioService;

    public VendedorService(VendedorRepository vendedorRepository, UsuarioRepository usuarioRepository, VestimentaRepository vestimentaRepository) {
        this.vendedorRepository = vendedorRepository;
        this.usuarioRepository = usuarioRepository;
        this.vestimentaRepository = vestimentaRepository;
    }

    @Transactional
    public Vendedor createVendedor(@RequestBody @NotNull VendedorRequestDTO vendedorRequestDTO){
        Usuario user = usuarioRepository.getReferenceById(vendedorRequestDTO.usuario_id());
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(vendedorRequestDTO.vestimentas_id());
        if(user == null){
            throw new NullPointerException("Usuário não encontrado");
        }
        if(vestimenta == null){
            throw new NullPointerException("Vestimenta não encontrada");
        }

        Vendedor vendedor = new Vendedor(user,vestimenta);
        vendedorRepository.save(vendedor);
        return vendedor;
    }

    @Transactional
    public VendedorResponseDTO getVendedorById(Long id){
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        return new VendedorResponseDTO(vendedor);
    }
    @Transactional
    public List<VendedorResponseDTO> getListVendedor(){
        List<VendedorResponseDTO> vendedor = vendedorRepository.findAll().stream().map(VendedorResponseDTO::new).toList();
        return vendedor;
    }

    public VendedorResponseDTO UpdateVendedor(@RequestBody AtualizaVendedorDTO atualizaVendedorDTO){
        Vendedor vendedor = vendedorRepository.getReferenceById(atualizaVendedorDTO.id());
        if(atualizaVendedorDTO.user() != null){
            usuarioService.updateUser(atualizaVendedorDTO.user());
        }
        vendedorRepository.save(vendedor);
        return new VendedorResponseDTO(vendedor);

    }
    @Transactional
    public void deleteVendedor(Long id){
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        vendedorRepository.delete(vendedor);
    }
}
