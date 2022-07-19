package com.alejandrogarcia.pruebatecnica.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrogarcia.pruebatecnica.entity.Categorias;
import com.alejandrogarcia.pruebatecnica.service.CategoriasService;

@RestController
public class CategoriasController {

	@Autowired
	private CategoriasService categoriaService;
	
	@GetMapping("/categoria")
	public Categorias getCategoriaById(@RequestParam(value = "id") long id) {
		
		return categoriaService.obtenerCategoriaById(id);
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categorias> postCategoria(@RequestBody Categorias categoria) {
		
		Categorias response = categoriaService.guardarCategoria(categoria);
		return ResponseEntity
	            .created(URI.create("ok")).body(response);
		
	}
}
