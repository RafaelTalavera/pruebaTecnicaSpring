package com.alejandrogarcia.pruebatecnica.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.dto.ProductosDTO;
import com.alejandrogarcia.pruebatecnica.entity.Productos;
import com.alejandrogarcia.pruebatecnica.repository.CategoriasRepository;
import com.alejandrogarcia.pruebatecnica.repository.ProductosRepository;

@Service
@Transactional
public class ProductosService {

	@Autowired
	private ProductosRepository productosRepository;
	
	@Autowired
	private CategoriasRepository categoriaRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	public ProductosDTO obtenerProductosById(long id) {
		
		return mapper.map(productosRepository.findById(id),ProductosDTO.class);
	}
	
	
	public Productos guardarProducto(ProductosDTO product) {
		//long idCat = product.getCategoria().getId();
		//Categorias categoria = categoriaRepository.findById(idCat);
		//categoria.getProductos().add(product);
		//product.setCategoria(categoria)
		Productos prod = mapper.map(product,Productos.class);
		 prod = productosRepository.save(prod);
		
		return prod;
	}
	
	
}
