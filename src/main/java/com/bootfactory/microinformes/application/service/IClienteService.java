package com.bootfactory.microinformes.application.service;

import com.bootfactory.microinformes.application.modelDTO.ReporteClienteDTO;
import com.bootfactory.microinformes.infrastructure.web.exceptions.FactoringBusinessLogicException;

public interface IClienteService {
	

	 ReporteClienteDTO listarCompradoresADC(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, int registroInicial, int numeroRegistros);
	
	ReporteClienteDTO listarClientesNoADC(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion,String nombre, int registroInicial, int numeroRegistros);
	
	ReporteClienteDTO listarPagadores(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, String nombre,int registroInicial, int numeroRegistros);
	
	 ReporteClienteDTO buscarPagador(Long idEntidadFinanciera, Long tipoIdentificacion, String identificacion,
			int registroInicial, int numeroRegistros);
	
	ReporteClienteDTO listarDeudores(Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, String nombre,int registroInicial, int numeroRegistros);
	
	 ReporteClienteDTO buscarDeudor(Long idEntidadFinanciera, Long tipoIdentificacion, String identificacion,
			int registroInicial, int numeroRegistros);
	 
	 ReporteClienteDTO listarClientesHabilitados(Long idEntidadFinanciera,Long codTipoIdentificacion, String identificacion, String nombre, int registroInicial, int numeroRegistros);

	ReporteClienteDTO listarVendedoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException;

	ReporteClienteDTO listarCompradoresPagoOperativo(boolean isBuscar,Long idEntidadFinanciera, Long tipoIdentificacion,
			String identificacion, String nombre, int registroInicial, int numeroRegistros) throws FactoringBusinessLogicException;

	

}
