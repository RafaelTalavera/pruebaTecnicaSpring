package com.alejandrogarcia.pruebatecnica.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.dto.ComprasDTO;
import com.alejandrogarcia.pruebatecnica.repository.ComprasRepository;

@Service

public class ComprasService {

	@Autowired
	private ComprasRepository comprasRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	public ComprasDTO getCompraById(long id) {
		
		return mapper.map(comprasRepository.getComprasById(id),ComprasDTO.class);
	}
	
	
	
}
