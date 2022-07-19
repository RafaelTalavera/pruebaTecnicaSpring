package com.alejandrogarcia.pruebatecnica.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.entity.Categorias;
import com.alejandrogarcia.pruebatecnica.repository.CategoriasRepository;

@Service
@Transactional
public class CategoriasService {

	@Autowired
	private CategoriasRepository categoriaRepository;
	
	
	public Categorias obtenerCategoriaById(long id) {
		return categoriaRepository.findById(id);
	}
	
	public Categorias guardarCategoria(Categorias categoria) {
		
		Categorias cat = categoriaRepository.save(categoria);
		
		return cat;
	}
}
