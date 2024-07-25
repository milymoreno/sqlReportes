package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.TipoTasaDTO;

public class TipoTasaResponse extends ResponseBody {
	
	List<TipoTasaDTO> datos;

	public List<TipoTasaDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<TipoTasaDTO> datos) {
		this.datos = datos;
	}
	


}
