package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VisInteresesDTO {

	private Long id;
	private String producto;
	private String obligacion;
	private String nombreDeudor;
	private BigDecimal interesesDia;
	private BigDecimal interesesAcumulados;
	private BigDecimal interesesMoraDia;
	private BigDecimal interesesMoraAcumulados;
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

	public BigDecimal getInteresesDia() {
		return interesesDia;
	}

	public void setInteresesDia(BigDecimal interesesDia) {
		this.interesesDia = interesesDia;
	}

	public BigDecimal getInteresesAcumulados() {
		return interesesAcumulados;
	}

	public void setInteresesAcumulados(BigDecimal interesesAcumulados) {
		this.interesesAcumulados = interesesAcumulados;
	}

	public BigDecimal getInteresesMoraDia() {
		return interesesMoraDia;
	}

	public void setInteresesMoraDia(BigDecimal interesesMoraDia) {
		this.interesesMoraDia = interesesMoraDia;
	}

	public BigDecimal getInteresesMoraAcumulados() {
		return interesesMoraAcumulados;
	}

	public void setInteresesMoraAcumulados(BigDecimal interesesMoraAcumulados) {
		this.interesesMoraAcumulados = interesesMoraAcumulados;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
