package com.alejandrogarcia.pruebatecnica.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alejandrogarcia.pruebatecnica.entity.Productos;

@Repository
@Transactional
public interface ProductosRepository extends CrudRepository<Productos, Long> {

	Productos findById(long id);
	
	
}
