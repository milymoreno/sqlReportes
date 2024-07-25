package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;



public class VisEstadoMMDTO {

	
	/** The tident. */
	private String tipoIdentificacion;
	
	/**num id */
	private String identificacion;
	
	/** The nombre. */
	private String nombre;
	
	
	/** The producto mm. */
	private String producto;
	
	/** The valor mm. */
	private BigDecimal montoMaximo;
	
	/** The disponible mm. */
	private BigDecimal disponible;
	
	/** The utilizado mm. */
	private BigDecimal utilizado;
	
	/** The estado mm. */
	private EnumEstadoEntidad estado;
	
	/** The moneda mm. */
	private String	moneda;
	
	/** The nombre_gerente. */
	private String	nombreGerente;

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
		public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public BigDecimal getMontoMaximo() {
		return montoMaximo;
	}

	public void setMontoMaximo(BigDecimal montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	public BigDecimal getDisponible() {
		return disponible;
	}

	public void setDisponible(BigDecimal disponible) {
		this.disponible = disponible;
	}

	public BigDecimal getUtilizado() {
		return utilizado;
	}

	public void setUtilizado(BigDecimal utilizado) {
		this.utilizado = utilizado;
	}

	public EnumEstadoEntidad getEstado() {
		return estado;
	}

	public void setEstado(EnumEstadoEntidad estado) {
		this.estado = estado;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getNombreGerente() {
		return nombreGerente;
	}

	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}
	
	

}
