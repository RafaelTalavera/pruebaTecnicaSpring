package com.alejandrogarcia.pruebatecnica.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrogarcia.pruebatecnica.dto.ComprasDTO;
import com.alejandrogarcia.pruebatecnica.service.ComprasService;

@RestController
@Transactional
public class ComprasController {

	@Autowired
	private ComprasService compraService;
	
	@GetMapping("/compras")
	public ResponseEntity<?> obtenerCompras(@RequestParam("id") long id){
		ComprasDTO response = compraService.getCompraById(id);
		if(null == response) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado la compra");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/compras")
	public ResponseEntity<?> añadirCompra(@RequestBody ComprasDTO compra,@RequestParam("id") long idUsuario){
		if(null != compra.getId()) {
			ComprasDTO existeCompra = compraService.getCompraById(compra.getId());
			if(null != existeCompra) {
				return ResponseEntity
			            .status(HttpStatus.FOUND)                 
			            .body("La compra ya existe");
			}
		}
		ComprasDTO response = compraService.postCompra(compra, idUsuario);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/comprasUsuario")
	public ResponseEntity<?> obtenerComprasUsuario(@RequestParam("id") long idUsuario){
		List<ComprasDTO> response = compraService.getCompras(idUsuario);
		if(response.isEmpty()) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se han encontrado compras");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	
	
}
