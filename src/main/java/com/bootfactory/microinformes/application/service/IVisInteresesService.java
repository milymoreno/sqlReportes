package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;

import com.bootfactory.microinformes.application.response.ReporteIntereses;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

public interface IVisInteresesService {
	
	
	public ReporteIntereses listarPaginado(Boolean esReporteMora,Long idProducto, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException;

}
