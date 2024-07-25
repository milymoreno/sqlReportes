package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_AMORTIZACION")
public class VisAmortizacion {

	@Id
	@Column(name = "ID_VISTA")
	private Long id;
	@Column(name = "NOMBRE_PRODUCTO")
	private String nombreProducto;
	@Column(name = "NUMERO_OBLIGACION")
	private String numeroObligacion;
	@Column(name = "NOMBRE_CLIENTE")
	private String nombreCliente;
	@Column(name = "APELLIDO1_CLIENTE")
	private String apellido1Cliente;
	@Column(name = "APELLIDO2_CLIENTE")
	private String apellido2Cliente;
	@Column(name = "SIGLA_CLIENTE")
	private String siglaCliente;
	@Column(name = "TIPO_CLIENTE")
	private Long tipoCliente;
	@Column(name = "AMORTIZACION_DIA")
	private BigDecimal amortizacionDia;
	@Column(name = "AMORTIZACION_ACUMULADA")
	private BigDecimal amortizacionAcumulada;
	@Column(name = "FECHA_AMORTIZACION")
	private Date fechaAmortizacion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getNumeroObligacion() {
		return numeroObligacion;
	}
	public void setNumeroObligacion(String numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellido1Cliente() {
		return apellido1Cliente;
	}
	public void setApellido1Cliente(String apellido1Cliente) {
		this.apellido1Cliente = apellido1Cliente;
	}
	public String getApellido2Cliente() {
		return apellido2Cliente;
	}
	public void setApellido2Cliente(String apellido2Cliente) {
		this.apellido2Cliente = apellido2Cliente;
	}
	public String getSiglaCliente() {
		return siglaCliente;
	}
	public void setSiglaCliente(String siglaCliente) {
		this.siglaCliente = siglaCliente;
	}
	public Long getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(Long tipoCliente) {
		this.tipoCliente = tipoCliente;
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
	public Date getFechaAmortizacion() {
		return fechaAmortizacion;
	}
	public void setFechaAmortizacion(Date fechaAmortizacion) {
		this.fechaAmortizacion = fechaAmortizacion;
	}
	
	

}
