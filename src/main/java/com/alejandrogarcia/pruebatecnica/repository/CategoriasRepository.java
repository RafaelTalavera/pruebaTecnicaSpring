package com.alejandrogarcia.pruebatecnica.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.alejandrogarcia.pruebatecnica.entity.Categorias;
@Transactional
public interface CategoriasRepository extends CrudRepository<Categorias, Long> {

	
	Categorias findById(long id);
	
	Categorias findByNombre(String nombre);
	
	
}
