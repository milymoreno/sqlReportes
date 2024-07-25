package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.VisAmortizacionDTO;

public class ReporteAmortizacion extends ResponseBody{
	List<VisAmortizacionDTO> datos;

	public List<VisAmortizacionDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<VisAmortizacionDTO> datos) {
		this.datos = datos;
	}
	
}
