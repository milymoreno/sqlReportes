package com.bootfactory.microinformes.domain.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_INTERESES")
public class VisIntereses {

	@Id
	@Column (name = "ID_VISTA")	
	private Long id;
	
	@Column (name = "NOMBRE_PRODUCTO")	
	private String nombreProducto;
	
	@Column (name = "NUMERO_OBLIGACION")
	private String numeroObligacion;
	
	@Column (name = "NOMBRE_CLIENTE")
	private String nombreCliente;
	
	@Column (name = "APELLIDO1_CLIENTE")
	private String apellido1Cliente;
	
	@Column (name = "APELLIDO2_CLIENTE")
	private String apellido2Cliente;
	
	@Column (name = "SIGLA_CLIENTE")
	private String siglaCliente;
	
	@Column (name = "TIPO_CLIENTE")
	private Long tipoCliente;
	
	@Column (name = "INTERESES_DIA")
	private BigDecimal interesesDia;
	
	@Column (name = "INTERESES_ACUMULADOS")
	private BigDecimal interesesAcumulados;
	
	@Column (name = "INTERESES_MORA_DIA")
	private BigDecimal interesesMoraDia;
	
	@Column (name = "INTERESES_MORA_ACUMULADOS")
	private BigDecimal interesesMoraAcumulados;
	
	@Column (name = "FECHA_CAUSACION")
	private Date fechaCausacion;
	
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
	public Date getFechaCausacion() {
		return fechaCausacion;
	}
	public void setFechaCausacion(Date fechaCausacion) {
		this.fechaCausacion = fechaCausacion;
	}
	
	
	
	

}
