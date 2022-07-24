package com.alejandrogarcia.pruebatecnica.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.dto.ComprasDTO;
import com.alejandrogarcia.pruebatecnica.entity.Clientes;
import com.alejandrogarcia.pruebatecnica.entity.CompraProducto;
import com.alejandrogarcia.pruebatecnica.entity.Compras;
import com.alejandrogarcia.pruebatecnica.entity.Productos;
import com.alejandrogarcia.pruebatecnica.repository.ClientesRepository;
import com.alejandrogarcia.pruebatecnica.repository.CompraProductoRepository;
import com.alejandrogarcia.pruebatecnica.repository.ComprasRepository;
import com.alejandrogarcia.pruebatecnica.repository.ProductosRepository;

@Service
@Transactional
public class ComprasService {

	@Autowired
	private ComprasRepository comprasRepository;
	
	@Autowired
	private ClientesRepository clienteRepository;
	
	@Autowired
	private ProductosRepository productoRepository;
	
	@Autowired
	private CompraProductoRepository compraProdRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	/**
	 * Obtener compra por id
	 * @param id
	 * @return ComprasDTO
	 */
	public ComprasDTO getCompraById(long id) {
		
		return mapper.map(comprasRepository.getComprasById(id),ComprasDTO.class);
	}
	/**
	 * Añadir una compra a un cliente
	 * @param idUsuario
	 * @return ComprasDTO
	 */
	public ComprasDTO postCompra(ComprasDTO compra,long idCliente) {
		Clientes cliente = clienteRepository.getClientesById(idCliente);
		
		ComprasDTO compraRes;
		Compras compraSave = mapper.map(compra, Compras.class);
		actualizarCantidadProducto(compraSave);
		
		cliente.getCompras().add(compraSave);
		
		compraSave = comprasRepository.save(compraSave);
		compraRes = mapper.map(compraSave, ComprasDTO.class);
		clienteRepository.save(cliente);

		return compraRes;
	}
	private void actualizarCantidadProducto(Compras compraSave) {
		for(CompraProducto transaccion : compraSave.getCompraProducto()) {
			
			Productos prod = transaccion.getProducto();
			if(prod.getCantidad() >= transaccion.getCantidad()) {
				prod.setCantidad(prod.getCantidad() - transaccion.getCantidad());
				productoRepository.save(prod);
			}
			compraProdRepository.save(transaccion);
		}
	}
	/**
	 * Obtener Compras vinculadas a un usuario
	 * @param idUsuario
	 * @return ComprasDTO
	 */
	public List<ComprasDTO> getCompras(long idUsuario){
		Clientes cliente = clienteRepository.getClientesById(idUsuario);
		List<Compras> compras = cliente.getCompras();
		List<ComprasDTO> comprasDTO = new ArrayList<ComprasDTO>();
		for(Compras com : compras) {
			
			comprasDTO.add(mapper.map(com, ComprasDTO.class));
		}
		
		return comprasDTO;
	}
	
}
