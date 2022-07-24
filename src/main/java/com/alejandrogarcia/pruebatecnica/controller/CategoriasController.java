package com.alejandrogarcia.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrogarcia.pruebatecnica.dto.CategoriasDTO;
import com.alejandrogarcia.pruebatecnica.service.CategoriasService;

@RestController
public class CategoriasController {

	@Autowired
	private CategoriasService categoriaService;
	
	@GetMapping("/categoria")
	public ResponseEntity<?> getCategoriaById(@RequestParam(value = "id") long id) {
		
		CategoriasDTO categoria = categoriaService.obtenerCategoriaById(id);
		if(null == categoria) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado la categoria");
		}
		
		return new ResponseEntity<>(categoria,HttpStatus.OK);
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<CategoriasDTO> postCategoria(@RequestBody CategoriasDTO categoria) {
		
		CategoriasDTO response = categoriaService.guardarCategoria(categoria);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
}
