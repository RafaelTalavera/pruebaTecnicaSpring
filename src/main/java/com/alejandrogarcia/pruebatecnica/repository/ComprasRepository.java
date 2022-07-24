package com.alejandrogarcia.pruebatecnica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alejandrogarcia.pruebatecnica.entity.Compras;

@Repository
public interface ComprasRepository extends CrudRepository<Compras, Long>{

	
	Compras getComprasById(long id);
	
	
}
