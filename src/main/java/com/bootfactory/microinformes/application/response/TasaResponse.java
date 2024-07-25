package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.TasaDTO;

public class TasaResponse extends ResponseBody {

	List<TasaDTO> datos;

	public List<TasaDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<TasaDTO> datos) {
		this.datos = datos;
	}

}
