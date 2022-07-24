package com.alejandrogarcia.pruebatecnica.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Compras {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	private Date fecha;
	
	private String metodo_pago;
	
	private String estado;
	
	@OneToMany(cascade = CascadeType.DETACH, orphanRemoval = true)
	@JoinColumn(name = "compra_producto_id")
	private List<CompraProducto> compraProducto;

	
	public Compras() {
		super();
	}

	public Compras(Long id, Date fecha, String metodo_pago, String estado, List<CompraProducto> compraProducto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.metodo_pago = metodo_pago;
		this.estado = estado;
		this.compraProducto = compraProducto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<CompraProducto> getCompraProducto() {
		return compraProducto;
	}

	public void setCompraProducto(List<CompraProducto> compraProducto) {
		this.compraProducto = compraProducto;
	}
	
	
	
	
}
