package com.alejandrogarcia.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrogarcia.pruebatecnica.dto.ClientesDTO;
import com.alejandrogarcia.pruebatecnica.service.ClientesService;

@RestController
public class ClientesController {

	@Autowired
	public ClientesService clientesService;

	@GetMapping("/cliente")
	public ResponseEntity<?> getCliente(@RequestParam(value = "id") long id) {
		
		ClientesDTO cliente = clientesService.getCliente(id);
		if(null == cliente) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado el cliente");
		}
		return new ResponseEntity<>(cliente,HttpStatus.OK);
		
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<?> registroCliente(@RequestBody ClientesDTO cliente) {
		ClientesDTO existeCliente = clientesService.getClienteByMail(cliente.getEmail());
		
		if(null != existeCliente) {
			return ResponseEntity
		            .status(HttpStatus.FOUND)                 
		            .body("El cliente ya existe");
		}
		ClientesDTO response = clientesService.postCliente(cliente);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@PutMapping("/cliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClientesDTO cliente){
		ClientesDTO existeCliente = clientesService.getCliente(cliente.getId());
		
		if(null == existeCliente) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado el cliente");
		}
		
		ClientesDTO response = clientesService.putCliente(cliente);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
