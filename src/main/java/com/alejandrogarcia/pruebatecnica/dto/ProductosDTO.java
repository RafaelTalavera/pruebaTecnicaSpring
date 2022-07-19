package com.alejandrogarcia.pruebatecnica.dto;

import java.util.List;


public class ProductosDTO {

	private Long id;
	
	private String nombre;
	
	private float precio;
	
	private int cantidad;

    private List<CategoriasDTO> categoria;

	public ProductosDTO() {
		super();
	}

	public ProductosDTO(Long id, String nombre, float precio, int cantidad, List<CategoriasDTO> categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<CategoriasDTO> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriasDTO> categoria) {
		this.categoria = categoria;
	}
    
    
	
}
