package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;

import com.bootfactory.microinformes.application.response.ReporteAmortizacion;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

public interface IVisAmortizacionService {

	ReporteAmortizacion listarPaginado(Long idProducto, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException;

}
