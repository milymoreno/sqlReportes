package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VisAmortizacionDTO {

	private Long id;
	private String producto;
	private String obligacion;
	private String nombreDeudor;
	private BigDecimal amortizacionDia;
	private BigDecimal amortizacionAcumulada;
	private LocalDateTime fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getObligacion() {
		return obligacion;
	}

	public void setObligacion(String obligacion) {
		this.obligacion = obligacion;
	}

	public String getNombreDeudor() {
		return nombreDeudor;
	}

	public void setNombreDeudor(String nombreDeudor) {
		this.nombreDeudor = nombreDeudor;
	}

	public BigDecimal getAmortizacionDia() {
		return amortizacionDia;
	}

	public void setAmortizacionDia(BigDecimal amortizacionDia) {
		this.amortizacionDia = amortizacionDia;
	}

	public BigDecimal getAmortizacionAcumulada() {
		return amortizacionAcumulada;
	}

	public void setAmortizacionAcumulada(BigDecimal amortizacionAcumulada) {
		this.amortizacionAcumulada = amortizacionAcumulada;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
