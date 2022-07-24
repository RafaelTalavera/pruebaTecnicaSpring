package com.alejandrogarcia.pruebatecnica.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alejandrogarcia.pruebatecnica.entity.CompraProducto;


@Repository
@Transactional
public interface CompraProductoRepository extends CrudRepository<CompraProducto, Long>{

	CompraProducto getCompraProductoById(long id);
	
	List<CompraProducto> findAll();
	
}
