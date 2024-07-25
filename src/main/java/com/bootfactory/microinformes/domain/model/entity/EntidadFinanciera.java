package com.bootfactory.microinformes.domain.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTIDADFINANCIERA")
public class EntidadFinanciera {

	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMID")
	private String numId;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "RAZONSOCIAL")
	private String razonSocial;
	
	
	@Column(name = "PORDCTODEV", columnDefinition = "NUMBER(9,6)")
	private Double porDctoDev;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Double getPorDctoDev() {
		return porDctoDev;
	}

	public void setPorDctoDev(Double porDctoDev) {
		this.porDctoDev = porDctoDev;
	}
	

}
