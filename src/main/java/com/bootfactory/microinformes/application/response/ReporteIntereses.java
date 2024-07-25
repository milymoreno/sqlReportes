package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisInteresesDTO;

public class ReporteIntereses  extends ResponseBody{

	
	List<VisInteresesDTO> datos;

	public List<VisInteresesDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<VisInteresesDTO> datos) {
		this.datos = datos;
	}
}
