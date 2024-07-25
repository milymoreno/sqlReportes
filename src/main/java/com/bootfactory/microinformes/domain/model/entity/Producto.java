package com.bootfactory.microinformes.domain.model.entity;

import java.io.Serializable;

import com.bootfactory.microinformes.domain.model.enums.EnumAplicacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOMBRE")
	private String nombre;

	@Id
	private Long id;

	@Version
	@Column(name = "VERSION")
	private Long version;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "TIPOAPLICACION")
	private EnumAplicacion tipoAplicacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public EnumAplicacion getTipoAplicacion() {
		return tipoAplicacion;
	}

	public void setTipoAplicacion(EnumAplicacion tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
