package com.bootfactory.microinformes.application.service;

import java.time.LocalDate;

import com.bootfactory.microinformes.application.response.ReporteAplicacionPago;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

public interface IVisAplicacionPagoService {

	ReporteAplicacionPago listarPaginado(Long idEntidadFinanciera,String referenciaPago, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, LocalDate fechaAplicacionContableInicial, LocalDate fechaAplicacionContableFinal,
			Long codTipoIdentificacionComprador, String identificacionComprador, Long codTipoIdentificacionVendedor,
			String identificacionVendedor, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException;

	

}
