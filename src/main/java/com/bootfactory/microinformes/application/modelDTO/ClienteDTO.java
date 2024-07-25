package com.bootfactory.microinformes.application.modelDTO;

import com.bootfactory.microinformes.domain.model.enums.EnumEstadoEntidad;
import com.bootfactory.microinformes.domain.model.enums.EnumTipoCliente;

public class ClienteDTO {
	
	/** Required by the Java Serialization Mechanism */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único del cliente
	 */
	private Long id;

	/**
	 * Número de identificación del cliente
	 */
	private String numeroIdentificacion;
	
	private String razonSocial; 
	
	private String sigla;
	
	/**
	 * Primer apellido del cliente para persona natural.
	 */
	private String apellido1;

	/**
	 * Segundo apellido del cliente para persona natural.
	 */
	private String apellido2;


	/**
	 * Nombre del cliente para persona natural.
	 */
	private String nombre;

	/**
	 * Entidad Financiera asociada al Cliente.
	 */
	private EntidadFinancieraDTO entidadFinanciera;

	/**
	 * Relacion que establece los tipos de identificación con las que se encuentra relacionado el cliente
	 */
	private TipoIdentificacionDTO tipoIdentificacion;

	/**
	 * Estado de la entidad
	 */
	private EnumEstadoEntidad estado;

	/**
	 * Tipo de cliente
	 */
	private EnumTipoCliente tipoCliente;

	/**
	 * Parámetro SI/NO indica si es fuente de pago
	 */
	
	private Boolean esFuentePago;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EntidadFinancieraDTO getEntidadFinanciera() {
		return entidadFinanciera;
	}

	public void setEntidadFinanciera(EntidadFinancieraDTO entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}

	public TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
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

	
}
