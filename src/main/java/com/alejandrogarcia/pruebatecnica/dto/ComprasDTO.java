package com.alejandrogarcia.pruebatecnica.dto;

import java.sql.Date;
import java.util.List;

public class ComprasDTO {

	private Long id;
	
	private Date fecha;
	
	private String metodo_pago;
	
	private String estado;
	
	private List<CompraProductoDTO> compraProducto;

	
	
	public ComprasDTO() {
		super();
	}

	public ComprasDTO(Long id, Date fecha, String metodo_pago, String estado, List<CompraProductoDTO> compraProducto) {
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

	public List<CompraProductoDTO> getCompraProducto() {
		return compraProducto;
	}

	public void setCompraProducto(List<CompraProductoDTO> compraProducto) {
		this.compraProducto = compraProducto;
	}
	
	
	
}
