package com.bootfactory.microinformes.application.service;

import com.bootfactory.microinformes.application.response.ReporteInformeCartera;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

public interface IVisInformeCarteraService {
	
	public ReporteInformeCartera listarPaginado(Long idEntidadFinanciera, Long codTipoIdentificacion,String identificacion,int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException;

}
