package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.RecaudosEsperadosDTO;

public class ReporteRecaudosEsperados extends ResponseBody {
	
	List<RecaudosEsperadosDTO> datos;

	public List<RecaudosEsperadosDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<RecaudosEsperadosDTO> datos) {
		this.datos = datos;
	}
	

}
