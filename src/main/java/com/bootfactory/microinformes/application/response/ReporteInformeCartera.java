package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisInformeCarteraDTO;

public class ReporteInformeCartera extends ResponseBody{
	
	List<VisInformeCarteraDTO> datos;

	public List<VisInformeCarteraDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<VisInformeCarteraDTO> datos) {
		this.datos = datos;
	}

}
