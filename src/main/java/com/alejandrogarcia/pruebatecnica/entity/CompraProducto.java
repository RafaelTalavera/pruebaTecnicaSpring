package com.alejandrogarcia.pruebatecnica.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CompraProducto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	private float total;
	
	private int cantidad;
	
	@OneToOne(cascade = CascadeType.DETACH, orphanRemoval = true)
	@JoinColumn(name = "productos_id", referencedColumnName = "id")
	private Productos producto;
	 
	public CompraProducto() {
		super();
	}

	public CompraProducto(Long id, float total, int cantidad, Productos producto) {
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

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	
	
	
}
