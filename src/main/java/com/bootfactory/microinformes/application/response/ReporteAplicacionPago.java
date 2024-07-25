package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisAplicacionPagoDTO;

public class ReporteAplicacionPago extends ResponseBody{
	List<VisAplicacionPagoDTO> datos;

	public List<VisAplicacionPagoDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<VisAplicacionPagoDTO> datos) {
		this.datos = datos;
	}
	
}
