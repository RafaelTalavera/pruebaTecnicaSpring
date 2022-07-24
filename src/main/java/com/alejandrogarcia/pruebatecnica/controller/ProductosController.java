package com.alejandrogarcia.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alejandrogarcia.pruebatecnica.dto.ProductosDTO;
import com.alejandrogarcia.pruebatecnica.service.ProductosService;


@RestController
public class ProductosController {

	@Autowired
	private ProductosService productoService;
	
	@GetMapping("/productos")
	public ResponseEntity<?> getProductoById(@RequestParam(value = "id") long id) {
		
		ProductosDTO response = productoService.obtenerProductosById(id);
		if(null == response) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado el producto");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> postProducto(@RequestBody ProductosDTO producto) {
		ProductosDTO response = productoService.guardarProducto(producto);
		if(null == response) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se han encontrado categorias");
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/productos")
	public ResponseEntity<?> deleteProductoById(@RequestParam(value = "id") long id) {
		
		boolean response = productoService.deleteProducto(id);
		if(response) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado el producto");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> putProducto(@RequestBody ProductosDTO producto) {
		ProductosDTO existeProducto = productoService.obtenerProductosById(producto.getId());
		if(null != existeProducto) {
			ProductosDTO categoriaUpdate = productoService.actualizarProducto(producto);
			return new ResponseEntity<>(categoriaUpdate,HttpStatus.OK);
		}else {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)                 
		            .body("No se ha encontrado el producto");
		}
		
	}
}
