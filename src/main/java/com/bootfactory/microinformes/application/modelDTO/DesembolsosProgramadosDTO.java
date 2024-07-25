package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;

public class DesembolsosProgramadosDTO {

	private String producto;
	private BigDecimal cantidad;
	private BigDecimal total;

	public DesembolsosProgramadosDTO(String producto, BigDecimal cantidad, BigDecimal total) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
