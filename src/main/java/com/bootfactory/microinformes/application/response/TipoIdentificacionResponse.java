package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;

public class TipoIdentificacionResponse extends ResponseBody {

	List<TipoIdentificacionDTO> datos;

	public List<TipoIdentificacionDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<TipoIdentificacionDTO> datos) {
		this.datos = datos;
	}
	
	
	
	
}
