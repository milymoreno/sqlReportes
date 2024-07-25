package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisAuxiliarContableDTO;

public class ReporteAuxiliarContable extends ResponseBody {
	
	List<VisAuxiliarContableDTO> datos;

	public List<VisAuxiliarContableDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<VisAuxiliarContableDTO> datos) {
		this.datos = datos;
	}
	
	

}
