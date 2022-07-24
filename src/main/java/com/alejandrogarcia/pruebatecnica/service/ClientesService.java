package com.alejandrogarcia.pruebatecnica.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandrogarcia.pruebatecnica.dto.ClientesDTO;
import com.alejandrogarcia.pruebatecnica.entity.Clientes;
import com.alejandrogarcia.pruebatecnica.repository.ClientesRepository;

@Service
@Transactional
public class ClientesService {

	@Autowired
	private ClientesRepository clienteRepository;

	
	ModelMapper mapper = new ModelMapper();
	
	public ClientesDTO getCliente(long id) {
		
		Clientes clienteBD = clienteRepository.getClientesById(id);
		ClientesDTO cliente = null;
		if(null != clienteBD) {
			cliente = mapper.map(clienteBD,ClientesDTO.class);
		}
		return cliente;
	}
	
	public ClientesDTO postCliente(ClientesDTO cliente) {
		
		ClientesDTO clienteDTO;
		Clientes clientes = mapper.map(cliente,Clientes.class);
		
		clientes = clienteRepository.save(clientes);
		
		clienteDTO = mapper.map(clientes, ClientesDTO.class);
		return clienteDTO;
	}
	
	public ClientesDTO putCliente(ClientesDTO cliente) {
		
		Clientes clienteModificado = mapper.map(cliente,Clientes.class);
		
		cliente = mapper.map(clienteRepository.save(clienteModificado), ClientesDTO.class);
		
		return cliente;
	}
	
	
	public ClientesDTO getClienteByMail(String mail) {
		ClientesDTO cliente;
		Clientes clienteBD = clienteRepository.getClientesByEmail(mail);
		if(clienteBD != null) {
			cliente = mapper.map(clienteBD, ClientesDTO.class);
			return cliente;
		}else {
			return null;
		}
		
	}
	
	
	
}
