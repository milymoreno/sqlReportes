package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.DesembolsosProgramadosDTO;

public class ReporteDesembolsosProgramados extends ResponseBody {
	
	List<DesembolsosProgramadosDTO> datos;

	public List<DesembolsosProgramadosDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<DesembolsosProgramadosDTO> datos) {
		this.datos = datos;
	}

}
