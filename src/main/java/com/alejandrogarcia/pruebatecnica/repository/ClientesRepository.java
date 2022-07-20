package com.alejandrogarcia.pruebatecnica.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alejandrogarcia.pruebatecnica.entity.Clientes;

@Repository
@Transactional
public interface ClientesRepository extends CrudRepository<Clientes, Long> {

	
	Clientes getClientesById(long id);
	
	List<Clientes> findAll();
}
