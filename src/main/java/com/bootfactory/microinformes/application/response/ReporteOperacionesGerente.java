package com.bootfactory.microinformes.application.response;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.OperacionesGerenteDTO;

public class ReporteOperacionesGerente  extends ResponseBody {
	List<OperacionesGerenteDTO> datos;

	public List<OperacionesGerenteDTO> getDatos() {
		return datos;
	}

	public void setDatos(List<OperacionesGerenteDTO> datos) {
		this.datos = datos;
	}
	

}
