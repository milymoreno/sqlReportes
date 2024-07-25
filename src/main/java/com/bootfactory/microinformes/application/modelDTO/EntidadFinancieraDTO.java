package com.bootfactory.microinformes.application.modelDTO;

public class EntidadFinancieraDTO {

	private Long id;

	private String numeroIdentificacion;

	private String nombre;

	private String razonSocial;

	private Double porDctoDev;

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
