package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bootfactory.microinformes.application.response.ReporteAuxiliarContable;

public interface IVisAuxiliarContableService {


	public ReporteAuxiliarContable listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion,
			int registroInicial, int registroFinal);

	
}
