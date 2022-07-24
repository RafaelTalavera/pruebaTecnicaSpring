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
	
	public CategoriasDTO obtenerCategoriaById(long id) {
		Categorias categoriaDB = categoriaRepository.findById(id);
		CategoriasDTO categoria = mapper.map(categoriaDB,CategoriasDTO.class);
		
		return categoria;
	}
	
	public CategoriasDTO guardarCategoria(CategoriasDTO categoria) {
		CategoriasDTO response;
		Categorias cat = mapper.map(categoria, Categorias.class);
		cat = categoriaRepository.save(cat);
		
		response = mapper.map(cat, CategoriasDTO.class);
		return response;
	}
}
