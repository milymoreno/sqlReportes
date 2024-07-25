package com.bootfactory.microinformes.application.modelDTO;

import com.bootfactory.microinformes.domain.model.enums.EnumAplicacion;

public class ProductoDTO {
	

	private String nombre;

	private Long id;

	
	private Long version;


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

	


}
