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

import com.alejandrogarcia.pruebatecnica.dto.ProductosDTO;
import com.alejandrogarcia.pruebatecnica.entity.Productos;
import com.alejandrogarcia.pruebatecnica.service.ProductosService;


@RestController
public class ProductosController {

	@Autowired
	private ProductosService productoService;
	
	@GetMapping("/productos")
	public ProductosDTO getProductoById(@RequestParam(value = "id") long id) {
		
		return productoService.obtenerProductosById(id);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<Productos> postProducto(@RequestBody ProductosDTO producto) {
		
		Productos response = productoService.guardarProducto(producto);
		return ResponseEntity
	            .created(URI.create("ok")).body(response);
		
	}
}
