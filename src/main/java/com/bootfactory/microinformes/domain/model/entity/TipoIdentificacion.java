package com.bootfactory.microinformes.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIDENT")
public class TipoIdentificacion {

	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * @todo add comment for javadoc
	 */
	
	private Long codigo;

	/**
	 * @todo add comment for javadoc
	 */
	
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
