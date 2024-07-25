package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;

public class RecaudosEsperadosDTO {

	private String producto;
	private BigDecimal capital;
	private BigDecimal interesCorrientes;
	private BigDecimal interesMora;
	private BigDecimal otros;
	private BigDecimal total;
	
	
	

	public RecaudosEsperadosDTO(String producto, BigDecimal capital, BigDecimal interesCorrientes,
			BigDecimal interesMora, BigDecimal otros, BigDecimal total) {
		super();
		this.producto = producto;
		this.capital = capital;
		this.interesCorrientes = interesCorrientes;
		this.interesMora = interesMora;
		this.otros = otros;
		this.total = total;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public BigDecimal getInteresCorrientes() {
		return interesCorrientes;
	}

	public void setInteresCorrientes(BigDecimal interesCorrientes) {
		this.interesCorrientes = interesCorrientes;
	}

	public BigDecimal getInteresMora() {
		return interesMora;
	}

	public void setInteresMora(BigDecimal interesMora) {
		this.interesMora = interesMora;
	}

	public BigDecimal getOtros() {
		return otros;
	}

	public void setOtros(BigDecimal otros) {
		this.otros = otros;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
