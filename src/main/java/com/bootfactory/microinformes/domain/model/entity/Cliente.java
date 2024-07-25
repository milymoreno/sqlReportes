package com.bootfactory.microinformes.domain.model.entity;

import java.io.Serializable;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoCliente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persona natural o jurídica que realiza negocios de Factoring a través de una
 * Entidad Financiera
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;


	@Column(name = "NUMID")
	private String numId;

	@Column(name = "RAZONSOCIAL")
	private String razonSocial;

	@Column(name = "SIGLA")
	private String sigla;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO1")
	private String apellido1;

	@Column(name = "APELLIDO2")
	private String apellido2;

	@JoinColumn(name = "ENTIDADFINANCIERA_ID")
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private EntidadFinanciera entidadFinanciera;

	@JoinColumn(name = "TIPOIDENTIFICACION_ID")
	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private TipoIdentificacion tipoIdentificacion;

	@Column(name = "ESTADO")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumEstadoEntidad estado;

	@Column(name = "TIPOCLIENTE")
	@Enumerated(value = EnumType.ORDINAL)
	private EnumTipoCliente tipoCliente;

	@Column(name = "ESFUENTEPAGO")
	private Boolean esFuentePago;

	@Column(name = "ESDEUDOR")
	private Boolean esDeudor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public EntidadFinanciera getEntidadFinanciera() {
		return entidadFinanciera;
	}

	public void setEntidadFinanciera(EntidadFinanciera entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public EnumEstadoEntidad getEstado() {
		return estado;
	}

	public void setEstado(EnumEstadoEntidad estado) {
		this.estado = estado;
	}

	public EnumTipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(EnumTipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Boolean getEsFuentePago() {
		return esFuentePago;
	}

	public void setEsFuentePago(Boolean esFuentePago) {
		this.esFuentePago = esFuentePago;
	}

	public Boolean getEsDeudor() {
		return esDeudor;
	}

	public void setEsDeudor(Boolean esDeudor) {
		this.esDeudor = esDeudor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
