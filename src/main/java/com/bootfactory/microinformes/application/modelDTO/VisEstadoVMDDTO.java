package com.bootfactory.microinformes.application.modelDTO;

import java.math.BigDecimal;
import java.util.Date;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;


public class VisEstadoVMDDTO {

	
	private String identificacionCliente;
	
	private String tipoIdentificacionCliente;
	
	private String nombreCliente;
	
	private String apellido1Cliente;

	private String apellido2Cliente;

	private String siglaCliente;
	
	private Long tipoCliente;
	
	private String producto;
	
	private String condicion;
	
	private String identificacionContraparte;
	
	private String tipoIdentificacionContraparte;
	
	private String nombreContraparte;
	
	private String apellido1Contraparte;

	private String apellido2Contraparte;

	private String siglaContraparte;
	
	private Long tipoContraparte;
	
	private String da;
	
	private String recibe;
	
	private Date fechaAprobacion;
	
	private Date fechaVigencia;
	
	private String modalidad;
	
	private BigDecimal valor;

	private BigDecimal disponible;

	private BigDecimal utilizado;

	private EnumEstadoEntidad estado;

	private String	moneda;

	private String	nombreGerente;

	private String	apellido1Gerente;

	private String apellido2Gerente;

	private String observacion;

	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public String getTipoIdentificacionCliente() {
		return tipoIdentificacionCliente;
	}

	public void setTipoIdentificacionCliente(String tipoIdentificacionCliente) {
		this.tipoIdentificacionCliente = tipoIdentificacionCliente;
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

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getIdentificacionContraparte() {
		return identificacionContraparte;
	}

	public void setIdentificacionContraparte(String identificacionContraparte) {
		this.identificacionContraparte = identificacionContraparte;
	}

	public String getTipoIdentificacionContraparte() {
		return tipoIdentificacionContraparte;
	}

	public void setTipoIdentificacionContraparte(String tipoIdentificacionContraparte) {
		this.tipoIdentificacionContraparte = tipoIdentificacionContraparte;
	}

	public String getNombreContraparte() {
		return nombreContraparte;
	}

	public void setNombreContraparte(String nombreContraparte) {
		this.nombreContraparte = nombreContraparte;
	}

	public String getApellido1Contraparte() {
		return apellido1Contraparte;
	}

	public void setApellido1Contraparte(String apellido1Contraparte) {
		this.apellido1Contraparte = apellido1Contraparte;
	}

	public String getApellido2Contraparte() {
		return apellido2Contraparte;
	}

	public void setApellido2Contraparte(String apellido2Contraparte) {
		this.apellido2Contraparte = apellido2Contraparte;
	}

	public String getSiglaContraparte() {
		return siglaContraparte;
	}

	public void setSiglaContraparte(String siglaContraparte) {
		this.siglaContraparte = siglaContraparte;
	}

	public Long getTipoContraparte() {
		return tipoContraparte;
	}

	public void setTipoContraparte(Long tipoContraparte) {
		this.tipoContraparte = tipoContraparte;
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getRecibe() {
		return recibe;
	}

	public void setRecibe(String recibe) {
		this.recibe = recibe;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public String getApellido1Gerente() {
		return apellido1Gerente;
	}

	public void setApellido1Gerente(String apellido1Gerente) {
		this.apellido1Gerente = apellido1Gerente;
	}

	public String getApellido2Gerente() {
		return apellido2Gerente;
	}

	public void setApellido2Gerente(String apellido2Gerente) {
		this.apellido2Gerente = apellido2Gerente;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	
}
