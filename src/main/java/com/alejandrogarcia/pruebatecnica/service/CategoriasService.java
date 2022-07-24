package com.alejandrogarcia.pruebatecnica.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.dto.CategoriasDTO;
import com.alejandrogarcia.pruebatecnica.entity.Categorias;
import com.alejandrogarcia.pruebatecnica.repository.CategoriasRepository;

@Service
@Transactional
public class CategoriasService {

	@Autowired
	private CategoriasRepository categoriaRepository;
	
	ModelMapper mapper = new ModelMapper();
	/**
	 * Obtener categoria por idCategoria
	 * @param id
	 * @return CategoriasDTO
	 */
	public CategoriasDTO obtenerCategoriaById(long id) {
		Categorias categoriaDB = categoriaRepository.findById(id);
		CategoriasDTO categoria = null;
		if(null != categoriaDB) {
			categoria = mapper.map(categoriaDB,CategoriasDTO.class);
		
			return categoria;
		}else {
			return null;
		}
	}
	/**
	 * Guardar categoria
	 * @param categoria
	 * @return CategoriasDTO
	 */
	public CategoriasDTO guardarCategoria(CategoriasDTO categoria) {
		CategoriasDTO response;
		Categorias cat = mapper.map(categoria, Categorias.class);
		cat = categoriaRepository.save(cat);
		
		response = mapper.map(cat, CategoriasDTO.class);
		return response;
	}
	/**
	 * Eliminar categoria
	 * @param id
	 * @return true -> eliminado false-> no eliminado
	 */
	public boolean deleteCategoria(long id) {
		Categorias categoria = categoriaRepository.findById(id);
		if(null != categoria) {
			categoriaRepository.delete(categoria);
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Actualizar categoria
	 * @param categoria
	 * @return CategoriasDTO
	 */
	public CategoriasDTO actualizaCategoria(CategoriasDTO categoria) {
		CategoriasDTO response;
		Categorias cat = mapper.map(categoria, Categorias.class);
		cat = categoriaRepository.save(cat);
		
		response = mapper.map(cat, CategoriasDTO.class);
		return response;
	}
}
