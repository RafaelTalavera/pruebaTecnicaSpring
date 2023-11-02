package com.alejandrogarcia.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrogarcia.pruebatecnica.dto.CategoriasDTO;
import com.alejandrogarcia.pruebatecnica.service.CategoriasService;

@RestController
@RequestMapping("/api")
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
	public ResponseEntity<?> postCategoria(@RequestBody CategoriasDTO categoria) {
		if(null != categoria.getId()) {
			CategoriasDTO existeCategoria = categoriaService.obtenerCategoriaById(categoria.getId());
			if(null != existeCategoria) {
				return ResponseEntity
			            .status(HttpStatus.FOUND)                 
			            .body("La categoria ya existe");
			}
		}
		CategoriasDTO response = categoriaService.guardarCategoria(categoria);
		return new ResponseEntity<>(response,HttpStatus.OK);
	
	}
	
	@DeleteMapping("/categoria")
	public ResponseEntity<?> deleteCategoria(@RequestParam("id") long id){
		boolean response = categoriaService.deleteCategoria(id);
		if(response) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado la categoria");
		}
		
	}
	
	@PutMapping("/categoria")
	public ResponseEntity<?> putCategoria(@RequestBody CategoriasDTO categoria){
		CategoriasDTO existeCategoria = categoriaService.obtenerCategoriaById(categoria.getId());
		if(null != existeCategoria) {
			CategoriasDTO categoriaUpdate = categoriaService.actualizaCategoria(categoria);
			return new ResponseEntity<>(categoriaUpdate,HttpStatus.OK);
		}else {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado la categoria");
		}
	}
}
