package br.com.engvini.bazar_virtual.service;

import br.com.engvini.bazar_virtual.domain.carrinhoCompras.CarrinhoCompras;
import br.com.engvini.bazar_virtual.domain.carrinhoCompras.CarrinhoComprasRepository;
import br.com.engvini.bazar_virtual.domain.carrinhoCompras.ComprasRequestDTO;
import br.com.engvini.bazar_virtual.domain.usuario.Usuario;
import br.com.engvini.bazar_virtual.domain.usuario.UsuarioRepository;
import br.com.engvini.bazar_virtual.domain.vendedor.Vendedor;
import br.com.engvini.bazar_virtual.domain.vendedor.VendedorRepository;
import br.com.engvini.bazar_virtual.domain.vestimenta.Vestimenta;
import br.com.engvini.bazar_virtual.domain.vestimenta.VestimentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class ComprasService {

    @Autowired
    private CarrinhoComprasRepository comprasRepository;

    @Autowired
    private VestimentaRepository vestimentaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public ComprasService(CarrinhoComprasRepository comprasRepository) {
        this.comprasRepository = comprasRepository;
    }

    @Transactional
    public CarrinhoCompras createCarrinhoCompras(ComprasRequestDTO comprasRequestDTO) {
        Usuario user = usuarioRepository.getReferenceById(comprasRequestDTO.usuario_id());
        Vestimenta vestimenta = vestimentaRepository.getReferenceById(comprasRequestDTO.vestimenta_id());
        if(user == null){
            throw new NullPointerException("Usuário não encontrado");
        }
        if(vestimenta == null){
            throw new NullPointerException("Vestimenta não encontrada");
        }

        CarrinhoCompras carrinhoCompras = new CarrinhoCompras(vestimenta,user,LocalDateTime.now());
        comprasRepository.save(carrinhoCompras);
        return carrinhoCompras;

    }

}
