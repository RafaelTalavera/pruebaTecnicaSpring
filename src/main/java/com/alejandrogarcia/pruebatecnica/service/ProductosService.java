package com.alejandrogarcia.pruebatecnica.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.dto.CategoriasDTO;
import com.alejandrogarcia.pruebatecnica.dto.ProductosDTO;
import com.alejandrogarcia.pruebatecnica.entity.Categorias;
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
	
	
	public ProductosDTO guardarProducto(ProductosDTO product) {

		ArrayList<Long> idsCategorias = new ArrayList<Long>();
		
		 for(CategoriasDTO cat : product.getCategoria()) {
			idsCategorias.add(cat.getId());
		 }
		 ArrayList<Categorias> categoriasBD = (ArrayList<Categorias>) categoriaRepository.findByIdIn(idsCategorias);
		 if(!categoriasBD.isEmpty()) {
			 
			 Productos prod = mapper.map(product,Productos.class);
			 prod = productosRepository.save(prod);
			 
			 ProductosDTO response = mapper.map(prod, ProductosDTO.class);
			
			return response;
		 }else {
			 return null;
		 }
	}
	
	public boolean deleteProducto(long id) {
		Productos productoBD = productosRepository.findById(id);
		if(null != productoBD) {
			productosRepository.delete(productoBD);
			return true;
		}else {
			return false;
		}
	}
	
	
	public ProductosDTO actualizarProducto(ProductosDTO product) {
		ProductosDTO response;
		Productos cat = mapper.map(product, Productos.class);
		cat = productosRepository.save(cat);
		
		response = mapper.map(cat, ProductosDTO.class);
		return response;
	}
	
}
