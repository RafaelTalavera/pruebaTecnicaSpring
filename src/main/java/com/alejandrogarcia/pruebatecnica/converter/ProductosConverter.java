package com.alejandrogarcia.pruebatecnica.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.alejandrogarcia.pruebatecnica.dto.ProductosDTO;

import com.alejandrogarcia.pruebatecnica.entity.Productos;

public class ProductosConverter {

	@Autowired
	private ModelMapper mapper;
	
	public Productos dtoToEntity(ProductosDTO producto) {
		
		Productos productoEntity =  mapper.map(producto,Productos.class); 
		/*Productos product = new Productos();
		ArrayList<Categorias> cat = new ArrayList<>();
		
		for(CategoriasDTO c : producto.getCategoria()) {
			Categorias temp = new Categorias();
			temp.setDescripcion(c.getDescripcion());
			temp.setId(c.getId());
			temp.setNombre(c.getNombre());
			cat.add(temp);
		}
		
		
		product.setCantidad(producto.getCantidad());
		product.setCategoria(cat);
		product.setId(producto.getId());
		product.setNombre(producto.getNombre());
		product.setPrecio(producto.getPrecio());
		*/
	return productoEntity;
	}
	
	
	public ProductosDTO entityToDTO(Productos producto) {
		
		/*ProductosDTO product = new ProductosDTO();
		ArrayList<CategoriasDTO> cat = new ArrayList<>();
		
		for(Categorias c : producto.getCategoria()) {
			CategoriasDTO temp = new CategoriasDTO();
			temp.setDescripcion(c.getDescripcion());
			temp.setId(c.getId());
			temp.setNombre(c.getNombre());
			cat.add(temp);
		}
		
		product.setCantidad(producto.getCantidad());
		product.setCategoria(cat);*/
		ProductosDTO productoDTO =  mapper.map(producto,ProductosDTO.class); 
		return productoDTO;
		
	}
}
