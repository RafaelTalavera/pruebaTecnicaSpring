package com.alejandrogarcia.pruebatecnica.dto;

import java.util.List;


public class CompraProductoDTO {

	private Long id;
	
	private float total;
	
	private int cantidad;

	private List<ProductosDTO> productos;

	public CompraProductoDTO() {
		super();
	}

	public CompraProductoDTO(Long id, float total, int cantidad, List<ProductosDTO> productos) {
		super();
		this.id = id;
		this.total = total;
		this.cantidad = cantidad;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<ProductosDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductosDTO> productos) {
		this.productos = productos;
	}
	
	
	
}
