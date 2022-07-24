package com.alejandrogarcia.pruebatecnica.dto;


public class CompraProductoDTO {

	private Long id;
	
	private float total;
	
	private int cantidad;

	private ProductosDTO producto;

	public CompraProductoDTO() {
		super();
	}

	public CompraProductoDTO(Long id, float total, int cantidad, ProductosDTO producto) {
		super();
		this.id = id;
		this.total = total;
		this.cantidad = cantidad;
		this.producto = producto;
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

	public ProductosDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductosDTO producto) {
		this.producto = producto;
	}
	
	
	
}
