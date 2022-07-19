package com.alejandrogarcia.pruebatecnica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;


@Entity
public class Productos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private float precio;
	
	private int cantidad;

	@OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "categoria_id")
    private List<Categorias> categoria;
	
	//@OneToMany(mappedBy="categoria", cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.LAZY)
	//private List<CompraProducto> productos;
	
	public Productos(Long id, String nombre, float precio, int cantidad,List<Categorias> categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}

	public List<Categorias> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categorias> categoria) {
		this.categoria = categoria;
	}

	public Productos() {
		
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
	
	
	
}
